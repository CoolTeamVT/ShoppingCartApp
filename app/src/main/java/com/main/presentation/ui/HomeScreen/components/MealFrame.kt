import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.shoppingcartapp.R
import com.main.presentation.ui.theme.MealFrameCategoryColor
import com.main.presentation.ui.theme.MealFrameColor
import com.main.presentation.ui.theme.ShoppingCartAppTheme
import com.main.utils.Dimens
import com.main.utils.FontFamilies
import com.main.utils.TextSizes

@Composable
fun MealFrame(
    category: String,
    onClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimens.homeScreenMealFrame)
            .background(
                color = MealFrameColor,
                shape = RoundedCornerShape(Dimens.homeScreenMealFrameRoundedShape))
            .clickable{
                onClicked()
            },

        contentAlignment = Alignment.Center
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = Dimens.homeScreenMealFramePadding
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
                    .clickable{
                        onClicked()
                    }
            ) {
                with(painter) {
                    draw(painter.intrinsicSize)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MealFramePreview() {
    ShoppingCartAppTheme {
        MealFrame(category = "breakfast", onClicked = {})
    }
}