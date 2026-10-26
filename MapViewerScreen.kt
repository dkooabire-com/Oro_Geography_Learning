package com.oro.geography.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun MapViewerScreen() {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp)) {
        Text("Geography Maps & Diagrams", style = MaterialTheme.typography.headlineSmall)
        Text("Simple offline learning diagrams. These are schematic illustrations, not navigation maps.", style = MaterialTheme.typography.bodySmall)
        Spacer(Modifier.height(16.dp))
        ElevatedCard {
            Column(Modifier.padding(12.dp)) {
                Text("Africa: Equator and Tropics", style = MaterialTheme.typography.titleMedium)
                Canvas(Modifier.fillMaxWidth().height(230.dp).background(MaterialTheme.colorScheme.surfaceVariant)) {
                    val w=size.width; val h=size.height
                    val continent = Path().apply {
                        moveTo(w*.37f,h*.08f); lineTo(w*.55f,h*.12f); lineTo(w*.64f,h*.28f)
                        lineTo(w*.59f,h*.42f); lineTo(w*.53f,h*.62f); lineTo(w*.48f,h*.89f)
                        lineTo(w*.40f,h*.72f); lineTo(w*.34f,h*.53f); lineTo(w*.25f,h*.38f)
                        lineTo(w*.29f,h*.22f); close()
                    }
                    drawPath(continent, color=androidx.compose.ui.graphics.Color(0xFFB9D8A8))
                    drawPath(continent, color=androidx.compose.ui.graphics.Color(0xFF356B48), style=Stroke(3f))
                    drawLine(androidx.compose.ui.graphics.Color(0xFFCC5555), Offset(w*.1f,h*.5f), Offset(w*.9f,h*.5f), 3f)
                    drawLine(androidx.compose.ui.graphics.Color(0xFF4778B8), Offset(w*.1f,h*.32f), Offset(w*.9f,h*.32f), 2f)
                    drawLine(androidx.compose.ui.graphics.Color(0xFF4778B8), Offset(w*.1f,h*.68f), Offset(w*.9f,h*.68f), 2f)
                }
                Text("Red: Equator • Blue: Tropics (schematic)", style = MaterialTheme.typography.bodySmall)
            }
        }
        Spacer(Modifier.height(12.dp))
        ElevatedCard {
            Column(Modifier.padding(12.dp)) {
                Text("East African Rift Valley", style = MaterialTheme.typography.titleMedium)
                Canvas(Modifier.fillMaxWidth().height(180.dp).background(MaterialTheme.colorScheme.surfaceVariant)) {
                    val w=size.width; val h=size.height
                    val p = Path().apply {
                        moveTo(w*.05f,h*.25f); lineTo(w*.28f,h*.25f); lineTo(w*.4f,h*.72f)
                        lineTo(w*.6f,h*.72f); lineTo(w*.72f,h*.25f); lineTo(w*.95f,h*.25f)
                    }
                    drawPath(p, androidx.compose.ui.graphics.Color(0xFF855E42), style=Stroke(7f))
                    drawLine(androidx.compose.ui.graphics.Color(0xFF4D91C6), Offset(w*.42f,h*.75f), Offset(w*.58f,h*.75f), 8f)
                }
                Text("Simplified cross-section showing a down-dropped rift between higher blocks.")
            }
        }
    }
}
