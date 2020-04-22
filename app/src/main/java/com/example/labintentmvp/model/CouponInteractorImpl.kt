package com.example.labintentmvp.model

import com.example.labintentmvp.presenter.CouponPresenter

class CouponInteractorImpl(var couponPresenter: CouponPresenter): CouponInteractor {

    private var couponRepository: CouponRepository = CouponRepositoryImpl(this)

    override fun loadListCoupons() {
        couponRepository.loadListCoupons()
    }

    override fun showErrorLoadCoupons(message: String?) {

        couponPresenter.showErrorLoadCoupons(message)

    }

    override fun sendListCoupons(coupons: ArrayList<Offer>) {

        couponPresenter.showListCoupons(coupons)

    }

}