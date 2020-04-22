package com.example.labintentmvp.model

interface CouponInteractor {

    fun loadListCoupons()
    fun showErrorLoadCoupons(message: String?)
    fun sendListCoupons(coupons: ArrayList<Offer>)
}