package com.example.labintentmvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.labintentmvp.R
import com.example.labintentmvp.model.ApiService
import com.example.labintentmvp.model.Coupons
import com.example.labintentmvp.model.Offer
import com.example.labintentmvp.presenter.CouponPresenter
import com.example.labintentmvp.presenter.CouponPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), CouponView {

    private var couponPresenter: CouponPresenter ?= null
    private var listCoupons = ArrayList<Offer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        couponPresenter = CouponPresenterImpl(this)

        loadList()
    }

    fun loadList() {

        couponPresenter?.loadListCoupons()

    }

    override fun showErrorLoadCoupons(message: String?){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }

    override fun showListCoupons(coupons: ArrayList<Offer>){

        listCoupons= coupons

        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        )

        val couponsRVAdapter = CouponsRVAdapter(listCoupons as ArrayList<Offer>)
        recyclerView.adapter = couponsRVAdapter
    }


}
