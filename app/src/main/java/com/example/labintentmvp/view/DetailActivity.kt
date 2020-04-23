package com.example.labintentmvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.labintentmvp.R
import com.example.labintentmvp.model.Offer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detalleoffer:Offer =intent?.getSerializableExtra("coupon") as Offer
        tv_titulo.text =detalleoffer.title
        tv_descrip.text=detalleoffer.description
        tv_tienda.text=detalleoffer.store
        if (!detalleoffer.imageUrl.isNullOrEmpty()) {
            Picasso.get().load(detalleoffer.imageUrl).into(iv_oferta)

        }
    }
}
