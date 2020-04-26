package com.example.labintentmvp.viewmodel

import android.R
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.labintentmvp.model.Offer
import com.squareup.picasso.Picasso
import retrofit2.Response.error


class DetailViewModel : ViewModel() {
    private var coupon: MutableLiveData<Offer> = MutableLiveData()

    fun setViewCoupon(coupon: Offer) {
        this.coupon.value = coupon
    }

    fun getCoupon()= coupon

    companion object{
        @JvmStatic
        @BindingAdapter("loadImageDetail")
        fun loadImageDetail(imageView: ImageView, imageUrl: String){

            if (!imageUrl.isNullOrEmpty()) {
                Picasso.get().load(imageUrl).into(imageView)
            }else
            {
                Picasso.get().load("https://previews.123rf.com/images/123vector/123vector1406/123vector140600002/28958389-ilustraci%C3%B3n-del-vector-del-icono-de-error-rojo-sobre-fondo-blanco.jpg").into(imageView)
            }

               // Picasso.with(context).load(new File(YOUR_FILE_PATH)).into(imageView)
                //Picasso.get().load("/drawable/ofertas.jpg").into(imageView);

        }
    }


}