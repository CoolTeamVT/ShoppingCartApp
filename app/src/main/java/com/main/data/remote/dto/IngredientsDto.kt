package com.main.data.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class IngredientsDto(
    @SerializedName("food") @Expose
    val food: String,
    @SerializedName("quantity") @Expose
    val quantity: Double,
    @SerializedName("measure") @Expose
    val measure: String,

)
