package com.example.labintentmvp.model

import androidx.lifecycle.MutableLiveData

interface CouponRepository {

    fun callCouponsAPI()
    fun getCoupons() : MutableLiveData<List<Offer>>
}