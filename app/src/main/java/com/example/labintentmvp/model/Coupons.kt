package com.example.labintentmvp.model


import com.google.gson.annotations.SerializedName

data class Coupons(
    @SerializedName("offers")
    val offers: List<Offer>,
    @SerializedName("result")
    val result: Boolean
)