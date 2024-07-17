package com.main.presentation.ui.SpeciesScreens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.main.presentation.ui.theme.DarkBlue
import com.main.utils.FontFamilies

@Composable
fun LazyColumnText(
    text: String,
) {
    Text(
        text = text,
        fontSize = 15.sp,
        fontFamily = FontFamilies.montserratMedium,
        color = DarkBlue,
        modifier = Modifier
            .padding(
                top = 15.dp,
                start = 15.dp,
                end = 15.dp
            )
    )
}