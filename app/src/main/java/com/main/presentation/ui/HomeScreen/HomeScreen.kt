
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.main.presentation.ui.theme.ShoppingCartAppTheme
import com.main.presentation.viewModels.MealsViewModel
import com.main.utils.Dimens
import com.main.utils.String
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: MealsViewModel = hiltViewModel()
) {
    val meals = viewModel.meals.collectAsState().value

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
            MealFrame(category = String.breakfastString) {
                val recipeId = meals.find { it.category == "Breakfast" }?.recipeId ?: 0
                navController.navigate("recipe_detail/$recipeId")
            }
            Spacer(modifier = Modifier.height(Dimens.homeScreenSpacer))
            MealFrame(category = String.lunchString) {
                val recipeId = meals.find { it.category == "Lunch" }?.recipeId ?: 0
                navController.navigate("recipe_detail/$recipeId")
            }
            Spacer(modifier = Modifier.height(Dimens.homeScreenSpacer))
            MealFrame(category = String.dinnerString) {
                val recipeId = meals.find { it.category == "Dinner" }?.recipeId ?: 0
                navController.navigate("recipe_detail/$recipeId")
            }
            Spacer(modifier = Modifier.height(Dimens.homeScreenSpacer))
            MealFrame(category = String.snacksString) {
                val recipeId = meals.find { it.category == "Snacks" }?.recipeId ?: 0
                navController.navigate("recipe_detail/$recipeId")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ShoppingCartAppTheme {
        HomeScreen(navController = rememberNavController())
    }
}