package com.example.labintentmvp.model


import androidx.lifecycle.MutableLiveData
import com.example.labintentmvp.model.server.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponRepositoryImpl : CouponRepository {

    private var coupons = MutableLiveData<List<Offer>>()

    override fun getCoupons() : MutableLiveData<List<Offer>>{
        return coupons
    }


    override fun callCouponsAPI() {
        val apiKey="7d83b9b1fc922ae00642f4a0ecea1679"
        var couponList : ArrayList<Offer>?= ArrayList()

        val incremental = 0
        val last_extract_datetime = ""
        val format = "json"
        val off_record= 1
        val last_extract = 1577505596

        ApiService.create()
            .getOffers(apiKey)
            .enqueue(object : Callback<Coupons> {
                override fun onFailure(call: Call<Coupons>, t: Throwable) {
                 //   couponInteractor.showErrorLoadCoupons(t.message)
                    //Log.d("Error", t.message)
                }

                override fun onResponse(call: Call<Coupons>, response: Response<Coupons>) {
                    if (response.isSuccessful) {

                     couponList = response.body()?.offers as ArrayList<Offer>
                        /*listCoupons = response.body()?.offers as ArrayList<Offer>
                        val couponsRVAdapter =
                            CouponsRVAdapter(
                                listCoupons
                            )
                        recyclerView.adapter = couponsRVAdapter
                    }*/
                }
                    coupons.value = couponList
            }

        })

    }

}
