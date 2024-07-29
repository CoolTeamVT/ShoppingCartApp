package com.main.data.Mappers

import com.main.domain.models.RecipeModel
import com.main.presentation.ui.SpeciesScreens.Specie

internal fun RecipeModel.toUiSpecie(): Specie {
    return Specie(
        id = id,
        name = name,
        imageUrl = imageUrl
    )
}