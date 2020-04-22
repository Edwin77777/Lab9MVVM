package com.example.labintentmvp.presenter

import com.example.labintentmvp.model.Offer

interface CouponPresenter {

    fun loadListCoupons()
    fun showErrorLoadCoupons(message: String?)
    fun showListCoupons(coupons: ArrayList<Offer>)


}