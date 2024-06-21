package com.main.data.API.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HitClass(
    @SerializedName("recipe") @Expose
    val recipe: RecipeClass
)
