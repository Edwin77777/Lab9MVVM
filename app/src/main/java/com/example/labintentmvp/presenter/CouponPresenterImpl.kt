package com.example.labintentmvp.presenter

import com.example.labintentmvp.model.CouponInteractor
import com.example.labintentmvp.model.CouponInteractorImpl
import com.example.labintentmvp.model.Offer
import com.example.labintentmvp.view.CouponView
import com.example.labintentmvp.view.MainActivity

class CouponPresenterImpl(var couponView: CouponView): CouponPresenter {

    private var couponInteractor: CouponInteractor = CouponInteractorImpl(this)

    override fun loadListCoupons() {

        couponInteractor.loadListCoupons()

    }

    override fun showErrorLoadCoupons(message: String?) {

        couponView.showErrorLoadCoupons(message)

    }



    override fun showListCoupons(coupons: ArrayList<Offer>) {
        couponView.showListCoupons(coupons)
    }
}