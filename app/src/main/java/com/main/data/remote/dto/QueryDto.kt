package com.main.data.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class QueryDto(
    @SerializedName("hits") @Expose
    val hits : List<HitDto>
)
