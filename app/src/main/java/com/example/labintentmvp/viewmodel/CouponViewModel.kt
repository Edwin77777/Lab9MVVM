package com.example.labintentmvp.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.labintentmvp.model.CouponObservable
import com.example.labintentmvp.model.Coupons
import com.example.labintentmvp.model.Offer
import com.example.labintentmvp.view.CouponsRVAdapter
import com.squareup.picasso.Picasso

class CouponViewModel : ViewModel() {

    private var couponObservable: CouponObservable = CouponObservable()
    private var couponsRVAdapter: CouponsRVAdapter ?= null
    private var couponSelected : MutableLiveData<Offer> = MutableLiveData()


    fun callCoupons(){
        couponObservable.callCoupons()
    }

    fun getCoupons() : MutableLiveData<List<Offer>>{
        return couponObservable.getCoupons()
    }

    fun setCouponsInCouponsAdapter(coupons: List<Offer>){
        couponsRVAdapter?.setCouponsList(coupons)
        couponsRVAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerCouponsAdapter() : CouponsRVAdapter? {
        couponsRVAdapter = CouponsRVAdapter(this)
        return couponsRVAdapter
    }
    fun getCouponsAt(position: Int): Offer?{
        var coupon: List<Offer>? = couponObservable.getCoupons().value
        return coupon?.get(position)
    }

    fun getCouponSelected() : MutableLiveData<Offer>{
        return couponSelected
    }
    fun onItemClick(position: Int){
        val coupon:Offer? = getCouponsAt(position)
        couponSelected.value = coupon

    }
    companion object{
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: ImageView,imageUrl: String){

            if (!imageUrl.isNullOrEmpty()) {
                Picasso.get().load(imageUrl).into(imageView)
            }else
            {
                Picasso.get().load("https://previews.123rf.com/images/123vector/123vector1406/123vector140600002/28958389-ilustraci%C3%B3n-del-vector-del-icono-de-error-rojo-sobre-fondo-blanco.jpg").into(imageView)
            }

        }
    }



}