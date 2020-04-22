package com.example.labintentmvp.model

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponRepositoryImpl(var couponInteractor: CouponInteractorImpl): CouponRepository {

    override fun loadListCoupons() {

        val apiKey="a5b8c00476b0974b91ab780966dec771"

        val incremental = 0
        val last_extract_datetime = ""
        val format = "json"
        val off_record= 1
        val last_extract = 1577505596

        ApiService.create()
            .getOffers(apiKey)
            .enqueue(object : Callback<Coupons> {
                override fun onFailure(call: Call<Coupons>, t: Throwable) {
                    couponInteractor.showErrorLoadCoupons(t.message)
                    //Log.d("Error", t.message)
                }

                override fun onResponse(call: Call<Coupons>, response: Response<Coupons>) {
                    if (response.isSuccessful) {

                        couponInteractor.sendListCoupons(response.body()?.offers as ArrayList<Offer>)
                        /*listCoupons = response.body()?.offers as ArrayList<Offer>
                        val couponsRVAdapter =
                            CouponsRVAdapter(
                                listCoupons
                            )
                        recyclerView.adapter = couponsRVAdapter
                    }*/
                }
            }

        })

    }

}
