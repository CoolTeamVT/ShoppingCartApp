package com.main.presentation.ui.RecipeDetailScreen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.shoppingcartapp.R
import com.main.domain.models.IngredientModel
import com.main.presentation.ui.theme.DarkBlue
import com.main.presentation.ui.theme.DarkWhite
import com.main.presentation.ui.theme.LightPink
import com.main.presentation.viewModels.RecipeViewModel
import com.main.utils.Dimens
import com.main.utils.FontFamilies


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailScreen(
    navController: NavController,
    recipeId: Int,
    viewModel: RecipeDetailViewModel = hiltViewModel(),
) {
    val recipe by viewModel.recipe.collectAsState()
    viewModel.onEvent(RecipeDetailScreenEvent.LoadDataEvent(recipeId))


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),

        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Header(recipe?.name, {})
        }
        item {
            Spacer(modifier = Modifier.height(23.dp))
        }

        item {
            ImageCard(recipe?.imageUrl)
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
            AmountView({}, {})
        }

        item {
            Spacer(modifier = Modifier.height(25.dp))

        }
        val items = recipe?.ingredients

        item {
            IngredientColumn(items = items)
        }

        item {
            Footer({})
        }
    }
}

@Composable
fun IngredientColumn(items: List<IngredientModel>?) {
    Column(
        modifier = Modifier
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
        items?.forEach { item ->
            ItemColumn(item)
        }

        Text(text = "")
    }
}

@Composable
fun ItemColumn(item: IngredientModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LazyColumnText(text = item.name)
        LazyColumnText(text = "${item.quantity} + ${item.measure}")
    }
}


@Composable
fun ImageCard(imageUrl: String?) {
    Box(
        Modifier.height(300.dp)
    ) {
        var isLoading by remember { mutableStateOf(true) }

        AsyncImage(
            model = imageUrl,
            contentDescription = "Image with Loading Indicator",
            modifier = Modifier.fillMaxSize(),
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
}


@Composable
fun Header(
    name: String?,
    onClick: () -> Unit,
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
                    onClick()
                }
        ) {
            with(painter) {
                rotate(90f) {
                    draw(painter.intrinsicSize)
                }
            }
        }
        Text(
            text = name ?: "",
            color = Color.Black,
            fontSize = 26.sp,
            fontFamily = FontFamilies.montserratMedium,
            modifier = Modifier
                .padding(start = 15.dp)
        )
    }
}

@Composable
fun AmountView(
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit,
) {
    Row(
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
                    onMinusClick()
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
                    onPlusClick()
                }
        ) {
            with(painterPlus) {
                draw(painterPlus.intrinsicSize)
            }
        }
    }
}

@Composable
fun Footer(
    onClick: () -> Unit,
) {
    Spacer(modifier = Modifier.height(25.dp))

    Button(
        modifier = Modifier
            .fillMaxWidth(0.3f),
        colors = ButtonColors(LightPink, DarkBlue, LightPink, DarkBlue),
        onClick = { onClick() }) {
        Text(
            text = "Add",
            fontSize = 20.sp
        )
    }
    Spacer(modifier = Modifier.height(25.dp))
}
