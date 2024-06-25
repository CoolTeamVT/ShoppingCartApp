package com.main.data.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RecipeDto(
    @SerializedName("label") @Expose
    val label: String,
    @SerializedName("image") @Expose
    val image: String,
    @SerializedName("ingredients") @Expose
    val ingredients: List<IngredientsDto>,
    @SerializedName("totalWeigh") @Expose
    val totalWeight: Double
)