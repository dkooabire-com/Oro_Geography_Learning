package com.oro.geography.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BookmarksScreen() {
    Column(Modifier.fillMaxSize().padding(18.dp)) {
        Text("Saved Study Materials", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(12.dp))
        Text("Your saved materials will appear here in a future version. For now, use the Learn tab to open notes and keep this project available on your device.")
        Spacer(Modifier.height(16.dp))
        ElevatedCard {
            Column(Modifier.padding(16.dp)) {
                Text("Offline-ready content", style = MaterialTheme.typography.titleMedium)
                Text("The sample notes, quiz questions, and schematic diagrams included in this app work without an internet connection.")
            }
        }
    }
}
