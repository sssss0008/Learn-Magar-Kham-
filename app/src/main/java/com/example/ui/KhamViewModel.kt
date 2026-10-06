package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.audio.AudioPronunciationManager
import com.example.data.KhamCategory
import com.example.data.KhamItem
import com.example.data.KhamRepository
import com.example.data.LanguageDisplayMode
import com.example.data.QuizQuestion
import com.example.data.UserPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class QuizState(
    val questions: List<QuizQuestion> = emptyList(),
    val currentIndex: Int = 0,
    val selectedAnswer: String? = null,
    val isSubmitted: Boolean = false,
    val isCorrect: Boolean = false,
    val correctCount: Int = 0,
    val isFinished: Boolean = false,
    val earnedPoints: Int = 0
)

data class MatchGameState(
    val pairs: List<Pair<String, String>> = emptyList(),
    val leftItems: List<String> = emptyList(),
    val rightItems: List<String> = emptyList(),
    val selectedLeft: String? = null,
    val selectedRight: String? = null,
    val matchedPairs: Set<String> = emptySet(),
    val mistakes: Int = 0,
    val isCompleted: Boolean = false
)

data class KhamUiState(
    val currentTab: Int = 0, // 0: Home, 1: Learn, 2: Practice, 3: About
    val searchQuery: String = "",
    val selectedCategory: KhamCategory? = null,
    val languageMode: LanguageDisplayMode = LanguageDisplayMode.TRILINGUAL,
    val bookmarkedIds: Set<String> = emptySet(),
    val masteredIds: Set<String> = emptySet(),
    val streakDays: Int = 3,
    val practiceScore: Int = 150,
    val quizzesCount: Int = 5,
    val selectedDetailItem: KhamItem? = null,
    val showPronunciationGuide: Boolean = false,
    val showCultureDetailId: String? = null,
    val showFeedbackDialog: Boolean = false,
    val showDictionaryDialog: Boolean = false,
    val learnViewMode: Int = 0, // 0: List, 1: Flashcards
    val currentFlashcardIndex: Int = 0,
    val isFlashcardFlipped: Boolean = false,
    val practiceMode: Int = 0, // 0: Menu, 1: Multiple Choice Quiz, 2: Word Match, 3: Audio Quiz
    val quizState: QuizState = QuizState(),
    val matchGameState: MatchGameState = MatchGameState()
)

class KhamViewModel(application: Application) : AndroidViewModel(application) {

    private val userPrefs = UserPreferences(application)
    val audioManager = AudioPronunciationManager(application)

    private val _uiState = MutableStateFlow(
        KhamUiState(
            bookmarkedIds = userPrefs.getBookmarkedIds(),
            masteredIds = userPrefs.getMasteredIds(),
            streakDays = userPrefs.getStreakDays(),
            practiceScore = userPrefs.getPracticeScore(),
            quizzesCount = userPrefs.getQuizzesCount(),
            languageMode = userPrefs.getLanguageMode()
        )
    )
    val uiState: StateFlow<KhamUiState> = _uiState.asStateFlow()

    fun selectTab(tabIndex: Int) {
        _uiState.update { it.copy(currentTab = tabIndex) }
    }

    fun onSearchQueryChanged(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun selectCategory(category: KhamCategory?) {
        _uiState.update {
            it.copy(
                selectedCategory = if (it.selectedCategory == category) null else category,
                currentFlashcardIndex = 0,
                isFlashcardFlipped = false
            )
        }
    }

    fun setLanguageMode(mode: LanguageDisplayMode) {
        userPrefs.setLanguageMode(mode)
        _uiState.update { it.copy(languageMode = mode) }
    }

    fun toggleBookmark(id: String) {
        userPrefs.toggleBookmark(id)
        _uiState.update { it.copy(bookmarkedIds = userPrefs.getBookmarkedIds()) }
    }

    fun toggleMastered(id: String) {
        val current = _uiState.value.masteredIds.contains(id)
        userPrefs.markMastered(id, !current)
        _uiState.update { it.copy(masteredIds = userPrefs.getMasteredIds()) }
    }

    fun openDetail(item: KhamItem) {
        _uiState.update { it.copy(selectedDetailItem = item) }
    }

    fun closeDetail() {
        _uiState.update { it.copy(selectedDetailItem = null) }
    }

    fun setPronunciationGuideVisible(visible: Boolean) {
        _uiState.update { it.copy(showPronunciationGuide = visible) }
    }

    fun setCultureDetailId(id: String?) {
        _uiState.update { it.copy(showCultureDetailId = id) }
    }

    fun setFeedbackDialogVisible(visible: Boolean) {
        _uiState.update { it.copy(showFeedbackDialog = visible) }
    }

    fun setDictionaryDialogVisible(visible: Boolean) {
        _uiState.update { it.copy(showDictionaryDialog = visible) }
    }

    fun setLearnViewMode(mode: Int) {
        _uiState.update { it.copy(learnViewMode = mode, isFlashcardFlipped = false) }
    }

    fun nextFlashcard(maxSize: Int) {
        if (maxSize <= 0) return
        _uiState.update {
            it.copy(
                currentFlashcardIndex = (it.currentFlashcardIndex + 1) % maxSize,
                isFlashcardFlipped = false
            )
        }
    }

    fun prevFlashcard(maxSize: Int) {
        if (maxSize <= 0) return
        _uiState.update {
            val newIdx = if (it.currentFlashcardIndex - 1 < 0) maxSize - 1 else it.currentFlashcardIndex - 1
            it.copy(currentFlashcardIndex = newIdx, isFlashcardFlipped = false)
        }
    }

    fun flipFlashcard() {
        _uiState.update { it.copy(isFlashcardFlipped = !it.isFlashcardFlipped) }
    }

    fun speakWord(khamDevanagari: String, phoneticFallback: String) {
        audioManager.speak(khamDevanagari, phoneticFallback)
    }

    // --- Practice & Quiz Operations ---
    fun startPracticeQuiz(mode: Int) {
        val questions = KhamRepository.quizQuestions.shuffled().take(6)
        _uiState.update {
            it.copy(
                practiceMode = mode,
                quizState = QuizState(
                    questions = questions,
                    currentIndex = 0,
                    selectedAnswer = null,
                    isSubmitted = false,
                    isCorrect = false,
                    correctCount = 0,
                    isFinished = false,
                    earnedPoints = 0
                )
            )
        }
    }

    fun startMatchGame() {
        val selected = KhamRepository.matchPairs.shuffled().take(5)
        val lefts = selected.map { it.first }.shuffled()
        val rights = selected.map { it.second }.shuffled()
        _uiState.update {
            it.copy(
                practiceMode = 2,
                matchGameState = MatchGameState(
                    pairs = selected,
                    leftItems = lefts,
                    rightItems = rights,
                    selectedLeft = null,
                    selectedRight = null,
                    matchedPairs = emptySet(),
                    mistakes = 0,
                    isCompleted = false
                )
            )
        }
    }

    fun selectQuizAnswer(option: String) {
        val qState = _uiState.value.quizState
        if (qState.isSubmitted || qState.isFinished) return
        val currentQ = qState.questions.getOrNull(qState.currentIndex) ?: return
        val isCorrect = option == currentQ.correctAnswer
        val earned = if (isCorrect) 25 else 0

        _uiState.update {
            it.copy(
                quizState = qState.copy(
                    selectedAnswer = option,
                    isSubmitted = true,
                    isCorrect = isCorrect,
                    correctCount = if (isCorrect) qState.correctCount + 1 else qState.correctCount,
                    earnedPoints = qState.earnedPoints + earned
                )
            )
        }
    }

    fun nextQuizQuestion() {
        val qState = _uiState.value.quizState
        val nextIdx = qState.currentIndex + 1
        if (nextIdx >= qState.questions.size) {
            // Finished
            userPrefs.addPracticeScore(qState.earnedPoints)
            userPrefs.incrementQuizzesCount()
            _uiState.update {
                it.copy(
                    practiceScore = userPrefs.getPracticeScore(),
                    quizzesCount = userPrefs.getQuizzesCount(),
                    quizState = qState.copy(isFinished = true)
                )
            }
        } else {
            _uiState.update {
                it.copy(
                    quizState = qState.copy(
                        currentIndex = nextIdx,
                        selectedAnswer = null,
                        isSubmitted = false,
                        isCorrect = false
                    )
                )
            }
        }
    }

    fun selectMatchItem(item: String, isLeft: Boolean) {
        val state = _uiState.value.matchGameState
        if (state.isCompleted) return

        if (isLeft) {
            if (state.selectedRight != null) {
                checkMatchPair(item, state.selectedRight)
            } else {
                _uiState.update { it.copy(matchGameState = state.copy(selectedLeft = item)) }
            }
        } else {
            if (state.selectedLeft != null) {
                checkMatchPair(state.selectedLeft, item)
            } else {
                _uiState.update { it.copy(matchGameState = state.copy(selectedRight = item)) }
            }
        }
    }

    private fun checkMatchPair(left: String, right: String) {
        val state = _uiState.value.matchGameState
        val isPairCorrect = state.pairs.any { it.first == left && it.second == right }
        if (isPairCorrect) {
            val newMatched = state.matchedPairs + left + right
            val isAllDone = newMatched.size >= state.pairs.size * 2
            if (isAllDone) {
                userPrefs.addPracticeScore(100)
                _uiState.update {
                    it.copy(
                        practiceScore = userPrefs.getPracticeScore(),
                        matchGameState = state.copy(
                            matchedPairs = newMatched,
                            selectedLeft = null,
                            selectedRight = null,
                            isCompleted = true
                        )
                    )
                }
            } else {
                _uiState.update {
                    it.copy(
                        matchGameState = state.copy(
                            matchedPairs = newMatched,
                            selectedLeft = null,
                            selectedRight = null
                        )
                    )
                }
            }
        } else {
            _uiState.update {
                it.copy(
                    matchGameState = state.copy(
                        selectedLeft = null,
                        selectedRight = null,
                        mistakes = state.mistakes + 1
                    )
                )
            }
        }
    }

    fun exitPracticeMode() {
        _uiState.update { it.copy(practiceMode = 0) }
    }

    override fun onCleared() {
        super.onCleared()
        audioManager.shutdown()
    }
}
