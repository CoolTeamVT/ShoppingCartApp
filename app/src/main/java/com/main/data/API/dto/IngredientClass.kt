package com.main.data.API.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class IngredientClass(
    @SerializedName("food") @Expose
    val food: String,
    @SerializedName("quantity") @Expose
    val quantity: Int,
    @SerializedName("measure") @Expose
    val measure: String,

)
