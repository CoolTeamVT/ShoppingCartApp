import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.main.presentation.ui.theme.ShoppingCartAppTheme
import com.main.utils.Dimens
import com.main.utils.String

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = Dimens.homeScreenHorizontalPadding,
                vertical = Dimens.homeScreenVerticalPadding
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {


            DateText(text = String.dateText)
            Spacer(modifier = Modifier.height(Dimens.homeScreenSpacer))
            MealFrame(category = String.breakfastString, {})
            Spacer(modifier = Modifier.height(Dimens.homeScreenSpacer))
            MealFrame(category = String.lunchString, {})
            Spacer(modifier = Modifier.height(Dimens.homeScreenSpacer))
            MealFrame(category = String.dinnerString, {})
            Spacer(modifier = Modifier.height(Dimens.homeScreenSpacer))
            MealFrame(category = String.snacksString, {})
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ShoppingCartAppTheme {
        HomeScreen()
    }
}