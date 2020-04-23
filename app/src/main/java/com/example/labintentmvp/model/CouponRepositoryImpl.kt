package com.example.labintentmvp.model

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponRepositoryImpl(var couponInteractor: CouponInteractorImpl): CouponRepository {

    override fun loadListCoupons() {

        val apiKey="7d83b9b1fc922ae00642f4a0ecea1679"

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
