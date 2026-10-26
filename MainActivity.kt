package com.oro.geography

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import com.oro.geography.ui.screens.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                colorScheme = lightColorScheme(
                    primary = androidx.compose.ui.graphics.Color(0xFF176B4D),
                    secondary = androidx.compose.ui.graphics.Color(0xFFE6A23C),
                    background = androidx.compose.ui.graphics.Color(0xFFF7F8F5)
                )
            ) { OroGeographyApp() }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OroGeographyApp() {
    val nav = rememberNavController()
    val destinations = listOf("curriculum", "maps", "quiz", "saved")
    val labels = listOf("Learn", "Maps", "Quiz", "Saved")
    var selected by remember { mutableIntStateOf(0) }
    Scaffold(
        topBar = { TopAppBar(title = { Text("Oro Geography Learning") }) },
        bottomBar = {
            NavigationBar {
                destinations.forEachIndexed { i, route ->
                    NavigationBarItem(
                        selected = selected == i,
                        onClick = {
                            selected = i
                            nav.navigate(route) { launchSingleTop = true; popUpTo("curriculum") { saveState = true }; restoreState = true }
                        },
                        icon = { Text(listOf("📚", "🌍", "✍️", "🔖")[i]) },
                        label = { Text(labels[i]) }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(navController = nav, startDestination = "curriculum", modifier = Modifier.padding(padding)) {
            composable("curriculum") { CurriculumScreen(nav) }
            composable("maps") { MapViewerScreen() }
            composable("quiz") { QuizScreen() }
            composable("saved") { BookmarksScreen() }
            composable("unit/{id}") { entry -> UnitDetailScreen(entry.arguments?.getString("id") ?: "") }
        }
    }
}
