import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.main.presentation.ui.theme.DateTextColor
import com.main.presentation.ui.theme.ShoppingCartAppTheme
import com.main.utils.TextSizes
import com.main.utils.FontFamilies


@Composable
fun DateText(
    text: String,
    onClick: () -> Unit
){
    Text(
        modifier = Modifier
            .clickable { onClick() },
        text = text,
        color = DateTextColor,
        fontWeight = FontWeight.Light,
        fontSize = TextSizes.homeScreenDateText,
        fontFamily = FontFamilies.montserratMedium
    )
}

@Preview
@Composable
fun preview() {
    ShoppingCartAppTheme {
        DateText(text = "Hello", {})
    }
}