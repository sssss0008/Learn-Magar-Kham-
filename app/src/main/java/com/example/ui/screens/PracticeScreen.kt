package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.CompareArrows
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.MatchGameState
import com.example.ui.QuizState

@Composable
fun PracticeScreen(
    practiceMode: Int, // 0: Menu, 1: Quiz, 2: Match Game, 3: Audio Quiz
    quizState: QuizState,
    matchGameState: MatchGameState,
    practiceScore: Int,
    quizzesCount: Int,
    streakDays: Int,
    onStartQuiz: (Int) -> Unit,
    onStartMatchGame: () -> Unit,
    onSelectQuizAnswer: (String) -> Unit,
    onNextQuizQuestion: () -> Unit,
    onSelectMatchItem: (String, Boolean) -> Unit,
    onSpeak: (String, String) -> Unit,
    onExitPractice: () -> Unit
) {
    when (practiceMode) {
        0 -> PracticeMenu(
            practiceScore = practiceScore,
            quizzesCount = quizzesCount,
            streakDays = streakDays,
            onStartQuiz = { onStartQuiz(1) },
            onStartMatchGame = onStartMatchGame,
            onStartAudioQuiz = { onStartQuiz(3) }
        )
        1, 3 -> QuizGameView(
            isAudioMode = practiceMode == 3,
            state = quizState,
            onSelectAnswer = onSelectQuizAnswer,
            onNextQuestion = onNextQuizQuestion,
            onSpeak = onSpeak,
            onExit = onExitPractice
        )
        2 -> MatchGameView(
            state = matchGameState,
            onSelectItem = onSelectMatchItem,
            onExit = onExitPractice,
            onPlayAgain = onStartMatchGame
        )
    }
}

@Composable
private fun PracticeMenu(
    practiceScore: Int,
    quizzesCount: Int,
    streakDays: Int,
    onStartQuiz: () -> Unit,
    onStartMatchGame: () -> Unit,
    onStartAudioQuiz: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Hero Score Card
        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "🏆 तपाईंको सिकाइ प्रगति (Your Score)",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.White.copy(alpha = 0.9f)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "$practiceScore अङ्क (Points)",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 32.sp
                    ),
                    color = Color(0xFFFFD54F)
                )
                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "$quizzesCount",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "खेलेका क्विज",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .height(30.dp)
                            .width(1.dp)
                            .background(Color.White.copy(alpha = 0.3f))
                    )

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "$streakDays दिन",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "निरन्तरता (Streak)",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "अभ्यास मोड छान्नुहोस् (Select Practice Mode)",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Mode 1: Multiple Choice
        PracticeModeCard(
            title = "१. बहुवैकल्पिक क्विज (Multiple Choice Quiz)",
            subtitle = "६ वटा प्रश्नहरूको सही उत्तर छानेर शब्द भण्डार जाँच्नुहोस्।",
            icon = Icons.Default.Quiz,
            iconBgColor = MaterialTheme.colorScheme.primary,
            tag = "+२५ अंक प्रति सही उत्तर",
            onClick = onStartQuiz,
            testTag = "quiz_mode_card"
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Mode 2: Word Match Game
        PracticeModeCard(
            title = "२. शब्द जोडा मिलाउने खेल (Word Match Challenge)",
            subtitle = "खाम शब्द र नेपाली/अङ्ग्रेजी अर्थ जोड्ने रमाइलो खेल।",
            icon = Icons.Default.CompareArrows,
            iconBgColor = MaterialTheme.colorScheme.secondary,
            tag = "+१०० अंक बोनस",
            onClick = onStartMatchGame,
            testTag = "match_mode_card"
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Mode 3: Audio Quiz
        PracticeModeCard(
            title = "३. ध्वनि र श्रवण क्विज (Audio Listening Quiz)",
            subtitle = "खाम बोली सुनेर सही अर्थ पत्ता लगाउनुहोस्।",
            icon = Icons.Default.Headphones,
            iconBgColor = MaterialTheme.colorScheme.tertiary,
            tag = "उच्चारण अभ्यास",
            onClick = onStartAudioQuiz,
            testTag = "audio_quiz_mode_card"
        )
    }
}

@Composable
private fun PracticeModeCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    iconBgColor: Color,
    tag: String,
    onClick: () -> Unit,
    testTag: String
) {
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .testTag(testTag)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(iconBgColor),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(26.dp)
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant
                ) {
                    Text(
                        text = tag,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun QuizGameView(
    isAudioMode: Boolean,
    state: QuizState,
    onSelectAnswer: (String) -> Unit,
    onNextQuestion: () -> Unit,
    onSpeak: (String, String) -> Unit,
    onExit: () -> Unit
) {
    if (state.isFinished) {
        // Quiz Finished Screen
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "🎉", fontSize = 54.sp)
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "बधाई छ! (Congratulations!)",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "तपाईंले ${state.questions.size} मध्ये ${state.correctCount} वटा प्रश्न मिलाउनुभयो!",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.secondaryContainer
            ) {
                Text(
                    text = "+${state.earnedPoints} अंक प्राप्त भयो!",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(28.dp))

            Button(
                onClick = onExit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("अभ्यास मेनुमा फर्कनुहोस् (Back to Practice)")
            }
        }
        return
    }

    val currentQ = state.questions.getOrNull(state.currentIndex) ?: return
    val progress = (state.currentIndex + 1).toFloat() / state.questions.size.toFloat()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Top Nav with Close
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onExit) {
                Icon(imageVector = Icons.Default.Close, contentDescription = "Exit Quiz")
            }

            Text(
                text = "प्रश्न ${state.currentIndex + 1} / ${state.questions.size}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.secondaryContainer
            ) {
                Text(
                    text = "🏆 ${state.earnedPoints}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Progress
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp)),
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Question Card
        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (isAudioMode) {
                    Text(
                        text = "🔊 आवाज सुन्नुहोस् र सही अर्थ छान्नुहोस्:",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    IconButton(
                        onClick = { onSpeak(currentQ.audioDevanagari, "") },
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary)
                    ) {
                        Icon(
                            imageVector = Icons.Default.VolumeUp,
                            contentDescription = "Speak",
                            tint = Color.White,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "आवाज पुनः सुन्न थिच्नुहोस्",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                } else {
                    Text(
                        text = currentQ.questionPrompt,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = currentQ.promptSubtext,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    if (currentQ.audioDevanagari.isNotBlank()) {
                        Spacer(modifier = Modifier.height(10.dp))
                        IconButton(
                            onClick = { onSpeak(currentQ.audioDevanagari, "") },
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.secondaryContainer)
                        ) {
                            Icon(
                                imageVector = Icons.Default.VolumeUp,
                                contentDescription = "Pronounce",
                                tint = MaterialTheme.colorScheme.onSecondaryContainer,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Options
        currentQ.options.forEach { option ->
            val isSelected = state.selectedAnswer == option
            val isCorrect = option == currentQ.correctAnswer

            val backgroundColor = when {
                !state.isSubmitted -> MaterialTheme.colorScheme.surface
                isSelected && isCorrect -> Color(0xFFD1FAE5) // Green
                isSelected && !isCorrect -> Color(0xFFFFE4E6) // Red
                state.isSubmitted && isCorrect -> Color(0xFFD1FAE5) // Highlight correct
                else -> MaterialTheme.colorScheme.surface
            }

            val borderColor = when {
                !state.isSubmitted && isSelected -> MaterialTheme.colorScheme.primary
                state.isSubmitted && isCorrect -> Color(0xFF10B981)
                state.isSubmitted && isSelected && !isCorrect -> Color(0xFFEF4444)
                else -> MaterialTheme.colorScheme.outline.copy(alpha = 0.4f)
            }

            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = backgroundColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp)
                    .border(1.5.dp, borderColor, RoundedCornerShape(14.dp))
                    .clickable(enabled = !state.isSubmitted) {
                        onSelectAnswer(option)
                    }
                    .testTag("quiz_option_${option.hashCode()}")
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = option,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.weight(1f)
                    )

                    if (state.isSubmitted) {
                        if (isCorrect) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "Correct",
                                tint = Color(0xFF10B981),
                                modifier = Modifier.size(22.dp)
                            )
                        } else if (isSelected) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Wrong",
                                tint = Color(0xFFEF4444),
                                modifier = Modifier.size(22.dp)
                            )
                        }
                    }
                }
            }
        }

        // Explanation & Next Button
        AnimatedVisibility(visible = state.isSubmitted) {
            Column(modifier = Modifier.padding(top = 16.dp)) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = if (state.isCorrect) Color(0xFFD1FAE5) else Color(0xFFFEF3C7),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(
                            text = if (state.isCorrect) "✓ बिल्कुल सही! (Correct)" else "✗ सही उत्तर बुझ्नुहोस्:",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = if (state.isCorrect) Color(0xFF065F46) else Color(0xFF92400E)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = currentQ.explanation,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = onNextQuestion,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .testTag("quiz_next_button"),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text(
                        if (state.currentIndex + 1 >= state.questions.size) "नतिजा हेर्नुहोस् (See Results)"
                        else "अर्को प्रश्न (Next Question) >"
                    )
                }
            }
        }
    }
}

@Composable
private fun MatchGameView(
    state: MatchGameState,
    onSelectItem: (String, Boolean) -> Unit,
    onExit: () -> Unit,
    onPlayAgain: () -> Unit
) {
    if (state.isCompleted) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "🎯", fontSize = 54.sp)
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "उत्कृष्ट! सबै जोडा मिल्यो!",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "तपाईंले खाम शब्द र अर्थ सफलतापूर्वक जोड्नुभयो।",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(10.dp))
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.secondaryContainer
            ) {
                Text(
                    text = "+१०० अंक प्राप्त भयो!",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = onPlayAgain,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Icon(imageVector = Icons.Default.Replay, contentDescription = null, modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("फेरि खेल्नुहोस् (Play Again)")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = onExit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surfaceVariant, contentColor = MaterialTheme.colorScheme.onSurfaceVariant)
            ) {
                Text("अभ्यास मेनुमा फर्कनुहोस्")
            }
        }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onExit) {
                Icon(imageVector = Icons.Default.Close, contentDescription = "Exit")
            }

            Text(
                text = "शब्द जोडा मिलाउनुहोस्",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = "गल्ती: ${state.mistakes}",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.outline
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "बायाँतर्फको खाम शब्द छानेर दायाँतर्फको सही अर्थ छुनुहोस्:",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Left Column (Kham)
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                state.leftItems.forEach { item ->
                    val isMatched = state.matchedPairs.contains(item)
                    val isSelected = state.selectedLeft == item

                    val bgColor = when {
                        isMatched -> Color(0xFFD1FAE5)
                        isSelected -> MaterialTheme.colorScheme.primaryContainer
                        else -> MaterialTheme.colorScheme.surface
                    }

                    Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = bgColor),
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                width = if (isSelected) 2.dp else 1.dp,
                                color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline.copy(alpha = 0.3f),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .clickable(enabled = !isMatched) {
                                onSelectItem(item, true)
                            }
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = item,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = if (isMatched) Color(0xFF065F46) else MaterialTheme.colorScheme.onSurface,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }

            // Right Column (Meaning)
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                state.rightItems.forEach { item ->
                    val isMatched = state.matchedPairs.contains(item)
                    val isSelected = state.selectedRight == item

                    val bgColor = when {
                        isMatched -> Color(0xFFD1FAE5)
                        isSelected -> MaterialTheme.colorScheme.primaryContainer
                        else -> MaterialTheme.colorScheme.surface
                    }

                    Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = bgColor),
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                width = if (isSelected) 2.dp else 1.dp,
                                color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline.copy(alpha = 0.3f),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .clickable(enabled = !isMatched) {
                                onSelectItem(item, false)
                            }
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = item,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.SemiBold,
                                color = if (isMatched) Color(0xFF065F46) else MaterialTheme.colorScheme.onSurface,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}
