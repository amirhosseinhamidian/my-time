package com.example.mytime.presenter.home

import android.annotation.SuppressLint
import android.graphics.Paint
import android.graphics.Path
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytime.domain.model.Task
import com.example.mytime.domain.model.TimeTaskInfo
import kotlin.math.round
import kotlin.math.roundToInt

@Composable
fun TimeItem(
    task: Task,
    hour: Int,
    minute: Int,
    infos: List<TimeTaskInfo> = emptyList(),
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colors.surface,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
            ) {
                Image(
                    painter = painterResource(id = task.iconResId),
                    contentDescription = "icon",
                    modifier = Modifier.size(32.dp)
                )
                Text(
                    text = task.title,
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onBackground,
                    maxLines = 2
                )
            }

            Row(
                modifier = Modifier.padding(vertical = 16.dp)
            ) {

                StockChart(
                    infos = infos
                )

                Text(
                    text = "${hour}h ${minute}m",
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onBackground
                )
            }
        }
    }
}

@SuppressLint("NewApi")
@Composable
fun StockChart(
    infos: List<TimeTaskInfo> = emptyList(),
    modifier: Modifier = Modifier,
    graphColor: Color = MaterialTheme.colors.secondaryVariant
){
    val spacing = 100f
    val transparentGraphColor = remember {
        graphColor.copy(alpha = 0.5f)
    }
    val upperValue = remember(infos) {
        (infos.maxOfOrNull { it.time }?.plus(1))?.roundToInt() ?: 0
    }
    val lowerValue = remember(infos) {
        (infos.minOfOrNull { it.time }?.toInt() ?: 0)
    }
    val density = LocalDensity.current
    val textPaint = remember(density) {
        Paint().apply {
            color = android.graphics.Color.WHITE
            textAlign = Paint.Align.CENTER
            textSize = density.run { 12.sp.toPx() }
        }
    }
    Canvas(modifier = modifier) {
        val spacePerDay = (size.width - spacing) / infos.size
        (0 until infos.size-1 step 2).forEach{i ->
            val info = infos[i]
            val day = info.date.dayOfWeek
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    day.toString(),
                    spacing + 1 * spacePerDay,
                    size.height - 5 ,
                    textPaint
                )
            }
        }
        val timeTaskStep = (upperValue - lowerValue) / 5f
        (0..4).forEach{i->
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    round(lowerValue + timeTaskStep *i).toString(),
                    30f,
                    size.height - spacing - i * size.height / 5f,
                    textPaint
                )
            }
        }
        var lastX = 0f
        val strokePath = androidx.compose.ui.graphics.Path().apply {
            val height = size.height
            for(i in infos.indices){
                val info = infos[i]
                val nextInfo = infos.getOrNull(i + 1) ?: infos.last()
                val leftRatio = (info.time - lowerValue) / (upperValue - lowerValue)
                val rightRatio = (nextInfo.time - lowerValue) / (upperValue - lowerValue)
                val x1 = spacing + i * spacePerDay
                val y1 = height - spacing - (leftRatio * height).toFloat()
                val x2 = spacing + (i+1) * spacePerDay
                val y2 = height - spacing - (rightRatio * height).toFloat()
                if (i == 0) {
                    moveTo(x1,y1)
                }
                lastX = (x1+x2)/2f
                quadraticBezierTo(
                    x1,y1,lastX,(y1+y2)/2f
                )
            }
        }
        val fillPath = Path(strokePath.asAndroidPath())
            .asComposePath()
            .apply {
                lineTo(lastX , size.height - spacing)
                lineTo(spacing,size.height - spacing)
                close()
            }
        drawPath(
            path = fillPath,
            brush = Brush.verticalGradient(
                colors = listOf(
                    transparentGraphColor,
                    Color.Transparent
                ),
                endY = size.height - spacing
            )
        )
        drawPath(
            path = strokePath,
            color = graphColor,
            style = Stroke(
                width = 3.dp.toPx(),
                cap = StrokeCap.Round
            )
        )
    }
}
