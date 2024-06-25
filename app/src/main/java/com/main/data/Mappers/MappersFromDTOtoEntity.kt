import com.main.data.local.RecipeApiDB.RecipeApiEntity
import com.main.data.remote.dto.RecipeDto

internal fun RecipeDto.toRecipeEntity(): RecipeApiEntity {
    return RecipeApiEntity(
        id = 0,
        name = label,
        grams = totalWeight,
        imageUrl = image
    )
}
