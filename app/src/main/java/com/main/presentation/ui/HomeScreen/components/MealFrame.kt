import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
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
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shoppingcartapp.R
import com.main.presentation.ui.theme.ExtendedMealFrameColor
import com.main.presentation.ui.theme.MealFrameCategoryColor
import com.main.presentation.ui.theme.MealFrameColor
import com.main.presentation.ui.theme.ShoppingCartAppTheme
import com.main.utils.Dimens
import com.main.utils.FontFamilies
import com.main.utils.TextSizes

@Composable
fun MealFrame(
    isExtended: Boolean,
    category: String,
    onExpandClicked: () -> Unit,
    onNavigateClicked: () -> Unit,

) {
    var frameHeight by remember {
        mutableStateOf(Dimens.homeScreenMealFrame)
    }
    var contentAlignment by remember {
        mutableStateOf(Alignment.Center)
    }
    var topPadding by remember {
        mutableStateOf(0.dp)
    }
    var isRotated by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(targetValue = if (isRotated || isExtended) 180f else 0f)

    Box(
        modifier = Modifier
            .animateContentSize()
            .fillMaxWidth()
            .height(if (isExtended) (frameHeight * 2) else frameHeight)
            .background(
                color = MealFrameColor,
                shape = RoundedCornerShape(Dimens.homeScreenMealFrameRoundedShape)
            ),

        contentAlignment = contentAlignment
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .padding(
                        horizontal = Dimens.homeScreenMealFramePadding,
                        vertical = topPadding
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = category,
                    fontFamily = FontFamilies.montserratSemibold,
                    fontSize = TextSizes.homeScreenMealFrameText,
                    color = MealFrameCategoryColor
                )

                val arrowDown = ImageVector.vectorResource(R.drawable.arrow_down)
                val painter = rememberVectorPainter(image = arrowDown)

                Canvas(
                    modifier = Modifier
                        .size(Dimens.homeScreenMealFrameImage)
                        .clickable {
                            isRotated = !isRotated
                            onExpandClicked()
                        }
                ) {
                    with(painter) {
                        rotate(degrees = rotation) {
                            draw(painter.intrinsicSize)
                        }
                    }
                }
            }
            if (isExtended) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        color = ExtendedMealFrameColor,
                        shape = RoundedCornerShape(
                            0.dp,
                            0.dp,
                            Dimens.homeScreenMealFrameRoundedShape,
                            Dimens.homeScreenMealFrameRoundedShape
                        )
                    )
                    .clickable { onNavigateClicked() },

                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        modifier = Modifier
                            .padding(
                                horizontal = Dimens.homeScreenMealFramePadding
                            ),
                        text = "Data",
                        fontFamily = FontFamilies.montserratSemibold,
                        fontSize = TextSizes.homeScreenMealFrameText,
                        color = MealFrameCategoryColor
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MealFramePreview() {
    ShoppingCartAppTheme {
        MealFrame(false, category = "breakfast",{}, {})
    }
}