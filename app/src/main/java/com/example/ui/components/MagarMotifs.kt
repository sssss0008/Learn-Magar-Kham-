package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp

@Composable
fun MagarTraditionalBorder(
    modifier: Modifier = Modifier,
    primaryColor: Color = Color(0xFF8B1E2D),
    secondaryColor: Color = Color(0xFFD97706)
) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(14.dp)
    ) {
        val width = size.width
        val step = 20f
        val numDiamonds = (width / step).toInt() + 1

        for (i in 0 until numDiamonds) {
            val cx = i * step
            // Draw diamond
            val path = Path().apply {
                moveTo(cx, 0f)
                lineTo(cx + step / 2f, size.height / 2f)
                lineTo(cx, size.height)
                lineTo(cx - step / 2f, size.height / 2f)
                close()
            }
            drawPath(
                path = path,
                color = if (i % 2 == 0) primaryColor else secondaryColor
            )

            // Center dot
            drawCircle(
                color = Color.White.copy(alpha = 0.8f),
                radius = 1.8f,
                center = Offset(cx, size.height / 2f)
            )
        }
    }
}

@Composable
fun MountainSilhouettes(
    modifier: Modifier = Modifier,
    color: Color = Color.White.copy(alpha = 0.25f)
) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height

        val path = Path().apply {
            moveTo(0f, h)
            lineTo(0f, h * 0.65f)
            lineTo(w * 0.18f, h * 0.35f)
            lineTo(w * 0.35f, h * 0.55f)
            lineTo(w * 0.55f, h * 0.2f)
            lineTo(w * 0.72f, h * 0.45f)
            lineTo(w * 0.88f, h * 0.25f)
            lineTo(w, h * 0.6f)
            lineTo(w, h)
            close()
        }
        drawPath(path = path, color = color)
    }
}
