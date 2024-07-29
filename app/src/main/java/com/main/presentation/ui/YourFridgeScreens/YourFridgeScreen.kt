package com.main.presentation.ui.YourFridgeScreens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shoppingcartapp.R
import com.main.utils.Dimens
import com.main.utils.FontFamilies

@Composable
fun YourFridgeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        Text(
            text = "Your Fridge",
            fontFamily = FontFamilies.montserratSemibold,
            fontSize = 42.sp,
            modifier = Modifier
                .padding(top = 21.dp)
        )

        Spacer(modifier = Modifier.height(70.dp))

        val painterFridge: Painter = painterResource(id = R.drawable.fridge_png)

        Image(
            painter = painterFridge,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(251.dp)
        )

        Spacer(modifier = Modifier.height(16.dp)) // Добавьте пространство между изображением и кнопками

        FridgeButton(text = "Detailed") {}
        FridgeButton(text = "Add ingredients") {}
    }

}