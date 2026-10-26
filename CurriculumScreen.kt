package com.oro.geography.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.oro.geography.data.CurriculumRepository

@Composable
fun CurriculumScreen(navController: NavController) {
    var grade by remember { mutableIntStateOf(9) }
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Learn Geography", style = MaterialTheme.typography.headlineSmall)
        Text("Notes and revision topics for Grades 9–12", style = MaterialTheme.typography.bodyMedium)
        Spacer(Modifier.height(12.dp))
        ScrollableTabRow(selectedTabIndex = grade - 9) {
            (9..12).forEach { g -> Tab(selected = grade == g, onClick = { grade = g }, text = { Text("Grade $g") }) }
        }
        Spacer(Modifier.height(12.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            items(CurriculumRepository.getUnitsForGrade(grade)) { unit ->
                ElevatedCard(Modifier.fillMaxWidth().clickable { navController.navigate("unit/${unit.id}") }) {
                    Column(Modifier.padding(16.dp)) {
                        Text("Unit ${unit.unitNumber}: ${unit.title}", style = MaterialTheme.typography.titleMedium)
                        Spacer(Modifier.height(5.dp))
                        Text(unit.description, style = MaterialTheme.typography.bodyMedium)
                        Spacer(Modifier.height(8.dp))
                        Text("Open notes  →", color = MaterialTheme.colorScheme.primary)
                    }
                }
            }
        }
    }
}

@Composable
fun UnitDetailScreen(id: String) {
    val unit = remember(id) { CurriculumRepository.getUnit(id) }
    Column(Modifier.fillMaxSize().padding(18.dp)) {
        if (unit == null) {
            Text("This topic could not be found.")
        } else {
            Text("Grade ${unit.grade} • Unit ${unit.unitNumber}", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
            Spacer(Modifier.height(8.dp))
            Text(unit.title, style = MaterialTheme.typography.headlineSmall)
            Spacer(Modifier.height(12.dp))
            Text(unit.description, style = MaterialTheme.typography.bodyMedium)
            HorizontalDivider(Modifier.padding(vertical = 12.dp))
            Text(unit.notes, style = MaterialTheme.typography.bodyLarge)
            Spacer(Modifier.height(16.dp))
            Text("Study tip: Review the key ideas, then test yourself in the Quiz tab.", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
