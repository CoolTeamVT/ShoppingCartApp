
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.main.presentation.ui.HomeScreen.HomeScreenEvent
import com.main.presentation.ui.theme.ShoppingCartAppTheme
import com.main.presentation.ui.HomeScreen.HomeScreenViewModel
import com.main.utils.Dimens
import com.main.utils.String
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val meals = viewModel.meals.collectAsState().value
    val isExtended by viewModel.isExpandedStateFlow.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = Dimens.homeScreenHorizontalPadding,
                vertical = Dimens.homeScreenVerticalPadding
            )
            .verticalScroll(rememberScrollState()),
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            DateText(text = String.dateText)
            Spacer(modifier = Modifier.height(Dimens.homeScreenSpacer))
            MealFrame(isExtended[0], category = String.breakfastString) {
                viewModel.onEvent(HomeScreenEvent.BoxExtensionFirstEvent)
            }
            Spacer(modifier = Modifier.height(Dimens.homeScreenSpacer))
            MealFrame(isExtended[1], category = String.lunchString) {
                viewModel.onEvent(HomeScreenEvent.BoxExtensionSecondEvent)
            }
            Spacer(modifier = Modifier.height(Dimens.homeScreenSpacer))
            MealFrame(isExtended[2], category = String.dinnerString) {
                viewModel.onEvent(HomeScreenEvent.BoxExtensionThirdEvent)
            }
            Spacer(modifier = Modifier.height(Dimens.homeScreenSpacer))
            MealFrame(isExtended[3], category = String.snacksString) {
                viewModel.onEvent(HomeScreenEvent.BoxExtensionFourthEvent)
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