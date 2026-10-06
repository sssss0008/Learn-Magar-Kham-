package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Celebration
import androidx.compose.material.icons.filled.Feedback
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material.icons.outlined.Celebration
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material.icons.outlined.School
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.KhamViewModel
import com.example.ui.components.AppDrawerContent
import com.example.ui.components.DictionaryDialog
import com.example.ui.components.FeedbackDialog
import com.example.ui.components.PronunciationGuideDialog
import com.example.ui.components.WordDetailSheet
import com.example.ui.screens.AboutCultureScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.LearnScreen
import com.example.ui.screens.PracticeScreen
import com.example.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                KhamAppRoot()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KhamAppRoot(viewModel: KhamViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    // Handle Back Press navigation
    BackHandler(enabled = drawerState.isOpen || uiState.practiceMode != 0 || uiState.currentTab != 0) {
        when {
            drawerState.isOpen -> coroutineScope.launch { drawerState.close() }
            uiState.practiceMode != 0 -> viewModel.exitPracticeMode()
            uiState.currentTab != 0 -> viewModel.selectTab(0)
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                AppDrawerContent(
                    currentTab = uiState.currentTab,
                    languageMode = uiState.languageMode,
                    onSelectTab = { tab ->
                        viewModel.selectTab(tab)
                    },
                    onSelectLanguageMode = { mode ->
                        viewModel.setLanguageMode(mode)
                    },
                    onOpenDictionary = { viewModel.setDictionaryDialogVisible(true) },
                    onOpenPronunciationGuide = { viewModel.setPronunciationGuideVisible(true) },
                    onOpenFeedbackDialog = { viewModel.setFeedbackDialogVisible(true) },
                    onCloseDrawer = { coroutineScope.launch { drawerState.close() } }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Column {
                            Text(
                                text = "मगर खाम (Magar Kham)",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                            Text(
                                text = when (uiState.currentTab) {
                                    0 -> "खाम् पाङ सिकाइ • Home"
                                    1 -> "शब्दावली र पाठहरू • Learn"
                                    2 -> "अभ्यास र क्विज खेल • Practice"
                                    else -> "संस्कृति र इतिहास • About"
                                },
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.85f)
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = { coroutineScope.launch { drawerState.open() } },
                            modifier = Modifier.testTag("nav_drawer_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu",
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    },
                    actions = {
                        // Quick Voice Greeting ("झोर्ले")
                        IconButton(
                            onClick = { viewModel.speakWord("झोर्ले", "Jhorle") },
                            modifier = Modifier.testTag("top_speaker_button")
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colorScheme.secondary),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.VolumeUp,
                                    contentDescription = "Speak Greeting",
                                    tint = Color.White,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }

                        // Search Dictionary
                        IconButton(
                            onClick = { viewModel.setDictionaryDialogVisible(true) },
                            modifier = Modifier.testTag("top_dictionary_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Dictionary",
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }

                        // Feedback quick shortcut
                        IconButton(
                            onClick = { viewModel.setFeedbackDialogVisible(true) },
                            modifier = Modifier.testTag("top_feedback_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Feedback,
                                contentDescription = "Feedback",
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary,
                        navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                        actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            },
            bottomBar = {
                NavigationBar(
                    modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars),
                    containerColor = MaterialTheme.colorScheme.surface,
                    tonalElevation = 6.dp
                ) {
                    val tabs = listOf(
                        NavigationTabItem(
                            index = 0,
                            label = "गृह (Home)",
                            selectedIcon = Icons.Filled.Home,
                            unselectedIcon = Icons.Outlined.Home,
                            tag = "tab_home"
                        ),
                        NavigationTabItem(
                            index = 1,
                            label = "सिकाइ (Learn)",
                            selectedIcon = Icons.Filled.School,
                            unselectedIcon = Icons.Outlined.School,
                            tag = "tab_learn"
                        ),
                        NavigationTabItem(
                            index = 2,
                            label = "अभ्यास (Practice)",
                            selectedIcon = Icons.Filled.Quiz,
                            unselectedIcon = Icons.Outlined.Quiz,
                            tag = "tab_practice"
                        ),
                        NavigationTabItem(
                            index = 3,
                            label = "विवरण (About)",
                            selectedIcon = Icons.Filled.Celebration,
                            unselectedIcon = Icons.Outlined.Celebration,
                            tag = "tab_about"
                        )
                    )

                    tabs.forEach { tab ->
                        val isSelected = uiState.currentTab == tab.index
                        NavigationBarItem(
                            selected = isSelected,
                            onClick = {
                                viewModel.selectTab(tab.index)
                                if (tab.index != 2 && uiState.practiceMode != 0) {
                                    viewModel.exitPracticeMode()
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = if (isSelected) tab.selectedIcon else tab.unselectedIcon,
                                    contentDescription = tab.label
                                )
                            },
                            label = {
                                Text(
                                    text = tab.label,
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = MaterialTheme.colorScheme.primary,
                                selectedTextColor = MaterialTheme.colorScheme.primary,
                                indicatorColor = MaterialTheme.colorScheme.primaryContainer
                            ),
                            modifier = Modifier.testTag(tab.tag)
                        )
                    }
                }
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                when (uiState.currentTab) {
                    0 -> HomeScreen(
                        streakDays = uiState.streakDays,
                        wordsMastered = uiState.masteredIds.size,
                        practiceScore = uiState.practiceScore,
                        languageMode = uiState.languageMode,
                        onSpeak = { devanagari, roman -> viewModel.speakWord(devanagari, roman) },
                        onWordClick = { item -> viewModel.openDetail(item) },
                        onCategoryClick = { category ->
                            viewModel.selectCategory(category)
                            viewModel.selectTab(1)
                        },
                        onStartPractice = {
                            viewModel.selectTab(2)
                            viewModel.startPracticeQuiz(1)
                        },
                        onOpenCultureArticle = { articleId ->
                            viewModel.selectTab(3)
                        },
                        onOpenDictionary = { viewModel.setDictionaryDialogVisible(true) },
                        onNavigateToLearn = { viewModel.selectTab(1) }
                    )

                    1 -> LearnScreen(
                        searchQuery = uiState.searchQuery,
                        selectedCategory = uiState.selectedCategory,
                        languageMode = uiState.languageMode,
                        bookmarkedIds = uiState.bookmarkedIds,
                        masteredIds = uiState.masteredIds,
                        viewMode = uiState.learnViewMode,
                        flashcardIndex = uiState.currentFlashcardIndex,
                        isFlashcardFlipped = uiState.isFlashcardFlipped,
                        onSearchChange = { viewModel.onSearchQueryChanged(it) },
                        onCategorySelect = { viewModel.selectCategory(it) },
                        onViewModeChange = { viewModel.setLearnViewMode(it) },
                        onNextFlashcard = { viewModel.nextFlashcard(it) },
                        onPrevFlashcard = { viewModel.prevFlashcard(it) },
                        onFlipFlashcard = { viewModel.flipFlashcard() },
                        onSpeak = { devanagari, roman -> viewModel.speakWord(devanagari, roman) },
                        onToggleBookmark = { viewModel.toggleBookmark(it) },
                        onToggleMastered = { viewModel.toggleMastered(it) },
                        onWordClick = { viewModel.openDetail(it) },
                        onOpenPronunciationGuide = { viewModel.setPronunciationGuideVisible(true) }
                    )

                    2 -> PracticeScreen(
                        practiceMode = uiState.practiceMode,
                        quizState = uiState.quizState,
                        matchGameState = uiState.matchGameState,
                        practiceScore = uiState.practiceScore,
                        quizzesCount = uiState.quizzesCount,
                        streakDays = uiState.streakDays,
                        onStartQuiz = { mode -> viewModel.startPracticeQuiz(mode) },
                        onStartMatchGame = { viewModel.startMatchGame() },
                        onSelectQuizAnswer = { viewModel.selectQuizAnswer(it) },
                        onNextQuizQuestion = { viewModel.nextQuizQuestion() },
                        onSelectMatchItem = { item, isLeft -> viewModel.selectMatchItem(item, isLeft) },
                        onSpeak = { dev, roman -> viewModel.speakWord(dev, roman) },
                        onExitPractice = { viewModel.exitPracticeMode() }
                    )

                    3 -> AboutCultureScreen(
                        onOpenFeedbackDialog = { viewModel.setFeedbackDialogVisible(true) }
                    )
                }
            }
        }
    }

    // Modal Word Detail Sheet
    uiState.selectedDetailItem?.let { item ->
        WordDetailSheet(
            item = item,
            isBookmarked = uiState.bookmarkedIds.contains(item.id),
            isMastered = uiState.masteredIds.contains(item.id),
            onSpeak = { viewModel.speakWord(item.khamDevanagari, item.khamRoman) },
            onToggleBookmark = { viewModel.toggleBookmark(item.id) },
            onToggleMastered = { viewModel.toggleMastered(item.id) },
            onDismiss = { viewModel.closeDetail() }
        )
    }

    // Pronunciation Guide Dialog
    if (uiState.showPronunciationGuide) {
        PronunciationGuideDialog(
            onSpeakSample = { viewModel.speakWord(it, "") },
            onDismiss = { viewModel.setPronunciationGuideVisible(false) }
        )
    }

    // Trilingual Dictionary Search Modal Dialog
    if (uiState.showDictionaryDialog) {
        DictionaryDialog(
            onSelectWord = { item -> viewModel.openDetail(item) },
            onSpeak = { dev, roman -> viewModel.speakWord(dev, roman) },
            onDismiss = { viewModel.setDictionaryDialogVisible(false) }
        )
    }

    // Feedback & Developer Contacts Dialog
    if (uiState.showFeedbackDialog) {
        FeedbackDialog(
            onDismiss = { viewModel.setFeedbackDialogVisible(false) }
        )
    }
}

private data class NavigationTabItem(
    val index: Int,
    val label: String,
    val selectedIcon: androidx.compose.ui.graphics.vector.ImageVector,
    val unselectedIcon: androidx.compose.ui.graphics.vector.ImageVector,
    val tag: String
)
