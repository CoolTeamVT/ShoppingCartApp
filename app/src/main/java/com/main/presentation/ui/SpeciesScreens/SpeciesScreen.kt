package com.main.presentation.ui.SpeciesScreens

import android.graphics.fonts.FontFamily
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.main.presentation.ui.theme.DarkWhite
import com.example.shoppingcartapp.R
import com.main.presentation.ui.theme.DarkBlue
import com.main.utils.Dimens
import com.main.utils.FontFamilies

@Composable
fun SpeciesScreen(navController: NavController){
    Box (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(color = Color.White),

        verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 10.dp,
                        top = 26.dp
                    ),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val arrowDown = ImageVector.vectorResource(R.drawable.arrow_down)
                val painter = rememberVectorPainter(image = arrowDown)

                Canvas(
                    modifier = Modifier
                        .size(Dimens.speciesScreenBackIcon)
                        .clickable {
                            //TODO()
                        }
                ) {
                    with(painter) {
                        rotate(90f) {
                            draw(painter.intrinsicSize)
                        }
                    }
                }
                Text(
                    text = "Сырники из творога",
                    color = Color.Black,
                    fontSize = 26.sp,
                    fontFamily = FontFamilies.montserratMedium,
                    modifier = Modifier
                        .padding(start = 15.dp)
                )
            }

            Spacer(modifier = Modifier.height(23.dp))

            Box(
                modifier = Modifier
            ) {
                var isLoading by remember { mutableStateOf(true) }

                AsyncImage(
                    model = "https://menunedeli.ru/wp-content/uploads/2015/07/20/Prostye-syrniki-iz-tvoroga_opt-3-500x334.jpg",
                    contentDescription = "Image with Loading Indicator",
                    modifier = Modifier.fillMaxWidth(),
                    onLoading = { isLoading = true },
                    onSuccess = { isLoading = false },
                    onError = { isLoading = false }
                )

                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(100.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val minusIcon = ImageVector.vectorResource(R.drawable.minus_icon)
                val plusIcon = ImageVector.vectorResource(R.drawable.plus_icon)
                val painterMinus = rememberVectorPainter(image = minusIcon)
                val painterPlus = rememberVectorPainter(image = plusIcon)

                Canvas(
                    modifier = Modifier
                        .size(Dimens.speciesScreenPlusMinusIcon)
                        .clickable {
                            //TODO()
                        }
                ) {
                    with(painterMinus) {
                        draw(painterMinus.intrinsicSize)
                    }
                }

                Text(
                    text = "Amount",
                    color = Color.Black,
                    fontSize = 26.sp,
                    fontFamily = FontFamilies.montserratMedium,
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                )

                Canvas(
                    modifier = Modifier
                        .size(Dimens.speciesScreenPlusMinusIcon)
                        .clickable {
                            //TODO()
                        }
                ) {
                    with(painterPlus) {
                        draw(painterPlus.intrinsicSize)
                    }
                }
            }

            Spacer(modifier = Modifier.height(25.dp))

            val items = listOf(
                IngredientClass("Quark", "84 gr."),
                IngredientClass("Flour", "13 gr."),
                IngredientClass("Eggs", "2 it."),
                IngredientClass("Sugar", "14 gr."),
                IngredientClass("Salt", "0.7 gr."),
                )
            Column (modifier = Modifier
                        .wrapContentHeight()
                        .padding(horizontal = 25.dp)
                        .background(color = DarkWhite, shape = RoundedCornerShape(30.dp)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Ingredients",
                    fontSize = 20.sp,
                    fontFamily = FontFamilies.montserratMedium,
                    color = DarkBlue,
                    modifier = Modifier
                        .padding(top = 6.dp)
                )
                

                LazyColumn(
                    modifier = Modifier
                ) {
                    items(items) { item ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Max),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            LazyColumnText(text = item.name)
                            LazyColumnText(text = item.amount)
                        }
                    }
                }

                Text(text = "")
            }


            Spacer(modifier = Modifier.height(25.dp))

            Button(
                modifier = Modifier,
                onClick = { /*TODO*/ }) {
                Text(
                    text = "Add"
                )
            }

        }
    }

}

data class IngredientClass(
    val name: String,
    val amount: String
)


@Preview(showBackground = true)
@Composable
fun SpeciesScreenPreview() {
    SpeciesScreen(navController = rememberNavController())
}