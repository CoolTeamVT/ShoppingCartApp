
import android.util.Log
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.calendar.models.CalendarStyle
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val meals = viewModel.meals.collectAsState().value
    val isExtended by viewModel.isExpandedStateFlow.collectAsState()
    val date by viewModel.date.collectAsState()
    val isCalendarPickerOpened by viewModel.isDatePickerOpened.collectAsState()

    val mealState by viewModel.mealsState.collectAsState()

    if (isCalendarPickerOpened) {
        CalendarDialog(
            state = rememberUseCaseState(visible = true),
            config = CalendarConfig(
                yearSelection = true,
                monthSelection = true,
                style = CalendarStyle.MONTH
            ),
            selection = CalendarSelection.Date { newDate ->
                viewModel.updateDate(newDate.toString())
            },
        )
    }

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
            DateText(text = date, onClick = {
                viewModel.onEvent(HomeScreenEvent.onDateClickedEvent)
            }
            )

            Spacer(modifier = Modifier.height(Dimens.homeScreenSpacer))

            MealFrame(
                mealState = mealState[0],
                isExtended = isExtended[0],
                category = String.breakfastString,
                onExpandClicked = {
                    viewModel.onEvent(HomeScreenEvent.BoxExtensionFirstEvent)
                },
                onNavigateClicked = {recipeId ->}
            )

            Spacer(modifier = Modifier.height(Dimens.homeScreenSpacer))

            MealFrame(
                mealState = mealState[1],
                isExtended = isExtended[1],
                category = String.lunchString,
                onExpandClicked = {
                    viewModel.onEvent(HomeScreenEvent.BoxExtensionSecondEvent)
                },
                onNavigateClicked = {recipeId ->}
                )

            Spacer(modifier = Modifier.height(Dimens.homeScreenSpacer))

            MealFrame(
                mealState = mealState[2],
                isExtended = isExtended[2],
                category = String.dinnerString,
                onExpandClicked =  {
                    viewModel.onEvent(HomeScreenEvent.BoxExtensionThirdEvent)
                },
                onNavigateClicked = {recipeId ->}
            )

            Spacer(modifier = Modifier.height(Dimens.homeScreenSpacer))

            MealFrame(
                mealState = mealState[3],
                isExtended = isExtended[3],
                category = String.snacksString,
                onExpandClicked = {
                    viewModel.onEvent(HomeScreenEvent.BoxExtensionFourthEvent)
                },
                onNavigateClicked = {recipeId ->}
            )
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