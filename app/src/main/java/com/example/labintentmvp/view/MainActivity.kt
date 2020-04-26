package com.example.labintentmvp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.labintentmvp.R
import com.example.labintentmvp.databinding.ActivityMainBinding
import com.example.labintentmvp.model.Offer
import com.example.labintentmvp.viewmodel.CouponViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var couponViewModel: CouponViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBinding(savedInstanceState)



    }

    fun setupBinding (savedInstanceState: Bundle?){


        var activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        couponViewModel = ViewModelProvider(this).get(CouponViewModel::class.java)

        activityMainBinding.model = couponViewModel
        setUpListUpdate()

    }

    private fun setUpListUpdate() {
        couponViewModel?.callCoupons()

        couponViewModel?.getCoupons()?.observe(this, Observer {coupon ->
            Log.d("Coupon", coupon[0].title)
            couponViewModel?.setCouponsInCouponsAdapter(coupon)

        })
        setupListClick()
    }

    fun setupListClick(){
        couponViewModel?.getCouponSelected()?.observe(this, Observer {coupon ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("coupon", coupon)
            startActivity(intent)

        })
    }


}
