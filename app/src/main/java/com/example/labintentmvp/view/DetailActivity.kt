package com.example.labintentmvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.labintentmvp.R
import com.example.labintentmvp.databinding.ActivityDetailBinding
import com.example.labintentmvp.model.Offer
import com.example.labintentmvp.viewmodel.DetailViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private var detailViewModel: DetailViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setupBinding(savedInstanceState)

    }

    fun setupBinding(savedInstanceState: Bundle?) {
        var activityDetailBinding: ActivityDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_detail)

        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        activityDetailBinding.model = detailViewModel
        activityDetailBinding.lifecycleOwner = this
        setUpListUpdate()


    }

    private fun setUpListUpdate() {

        detailViewModel?.setViewCoupon(intent?.getSerializableExtra("coupon") as Offer)
    }
}








       /* val detalleoffer:Offer =intent?.getSerializableExtra("coupon") as Offer
        tv_titulo.text =detalleoffer.title
        tv_descrip.text=detalleoffer.description
        tv_tienda.text=detalleoffer.store
        if (!detalleoffer.imageUrl.isNullOrEmpty()) {
            Picasso.get().load(detalleoffer.imageUrl).into(iv_oferta)

        }*/


