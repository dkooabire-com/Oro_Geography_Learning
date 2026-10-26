package com.oro.geography.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oro.geography.data.CurriculumRepository

@Composable
fun QuizScreen() {
    val questions = remember { CurriculumRepository.questions.shuffled() }
    var index by remember { mutableIntStateOf(0) }
    var answer by remember { mutableStateOf<Int?>(null) }
    var submitted by remember { mutableStateOf(false) }
    var score by remember { mutableIntStateOf(0) }
    var finished by remember { mutableStateOf(false) }
    Column(Modifier.fillMaxSize().padding(18.dp)) {
        Text("Geography Practice Quiz", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(12.dp))
        if (finished) {
            Text("Quiz completed!", style = MaterialTheme.typography.titleLarge)
            Text("Your score: $score / ${questions.size}", style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.height(16.dp))
            Button(onClick = { index = 0; answer = null; submitted = false; score = 0; finished = false }) { Text("Try Again") }
        } else {
            val q = questions[index]
            LinearProgressIndicator(progress = { (index + 1f) / questions.size }, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(12.dp))
            Text("Question ${index + 1} of ${questions.size}", style = MaterialTheme.typography.labelLarge)
            Spacer(Modifier.height(8.dp))
            Text(q.question, style = MaterialTheme.typography.titleLarge)
            Spacer(Modifier.height(12.dp))
            q.options.forEachIndexed { i, option ->
                OutlinedCard(
                    onClick = { if (!submitted) answer = i },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    colors = CardDefaults.outlinedCardColors(
                        containerColor = when {
                            submitted && i == q.correctAnswer -> MaterialTheme.colorScheme.primaryContainer
                            submitted && answer == i -> MaterialTheme.colorScheme.errorContainer
                            answer == i -> MaterialTheme.colorScheme.secondaryContainer
                            else -> MaterialTheme.colorScheme.surface
                        }
                    )
                ) { Text("${'A' + i}. $option", Modifier.padding(14.dp)) }
            }
            if (submitted) {
                Spacer(Modifier.height(8.dp))
                Text("Explanation: ${q.explanation}", style = MaterialTheme.typography.bodyMedium)
            }
            Spacer(Modifier.weight(1f))
            Button(
                onClick = {
                    if (!submitted) {
                        submitted = true
                        if (answer == q.correctAnswer) score++
                    } else if (index < questions.lastIndex) {
                        index++; answer = null; submitted = false
                    } else finished = true
                },
                enabled = if (submitted) true else answer != null,
                modifier = Modifier.fillMaxWidth()
            ) { Text(if (!submitted) "Check Answer" else if (index == questions.lastIndex) "See Results" else "Next Question") }
        }
    }
}
