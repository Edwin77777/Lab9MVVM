package com.example.labintentmvp.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class CouponObservable : BaseObservable() {

    private var couponRepositoryImpl: CouponRepository = CouponRepositoryImpl()

    fun callCoupons(){
        couponRepositoryImpl.callCouponsAPI()
    }

    fun getCoupons() : MutableLiveData<List<Offer>>{
        return couponRepositoryImpl.getCoupons()
    }

}