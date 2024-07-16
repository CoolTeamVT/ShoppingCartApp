import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.main.presentation.ui.theme.DateTextColor
import com.main.utils.TextSizes
import com.main.utils.FontFamilies


@Composable
fun DateText(
    text: String,
){
    Text(
        text = text,
        color = DateTextColor,
        fontWeight = FontWeight.Light,
        fontSize = TextSizes.homeScreenDateText,
        fontFamily = FontFamilies.montserratMedium
    )
}