package com.main.data.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HitDto(
    @SerializedName("recipe") @Expose
    val recipe: RecipeDto
)
