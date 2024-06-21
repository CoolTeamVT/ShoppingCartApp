package com.main.data.API.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RecipeClass(
    @SerializedName("label") @Expose
    val label: String,
    @SerializedName("image") @Expose
    val image: String,
    @SerializedName("ingredients") @Expose
    val ingredients: List<IngredientClass>,
    @SerializedName("totalWeigh") @Expose
    val totalWeight: Double
)