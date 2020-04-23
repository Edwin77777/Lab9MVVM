package com.example.labintentmvp.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Coupons(
    @SerializedName("offers")
    val offers: List<Offer>,
    @SerializedName("result")
    val result: Boolean
):Serializable