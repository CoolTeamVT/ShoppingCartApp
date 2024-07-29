package com.main.presentation.ui.YourFridgeScreens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppingcartapp.R
import com.main.presentation.ui.theme.DarkBlue
import com.main.utils.FontFamilies

@Composable
fun FridgeButton(
    text: String,
    onButtonClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(70.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            color = DarkBlue,
            fontFamily = FontFamilies.montserratSemibold,
            modifier = Modifier
                .clickable { onButtonClick() }
        )

        val arrowDown = ImageVector.vectorResource(R.drawable.arrow_down)
        val painter = rememberVectorPainter(image = arrowDown)

        Canvas(
            modifier = Modifier
                .size(30.dp)
                .clickable { onButtonClick() }

        ) {
            with(painter) {
                rotate(degrees = 270f) {
                    draw(painter.intrinsicSize)
                }
            }
        }


    }
}


@Preview(showBackground = true)
@Composable
fun prev() {
    FridgeButton("text") {}
}