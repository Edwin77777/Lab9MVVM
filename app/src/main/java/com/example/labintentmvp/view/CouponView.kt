package com.example.labintentmvp.view

import com.example.labintentmvp.model.Offer

interface CouponView {

    fun showErrorLoadCoupons(message: String?)
    fun showListCoupons(coupons: ArrayList<Offer>)
}