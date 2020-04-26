package com.example.labintentmvp.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.labintentmvp.BR
import com.example.labintentmvp.R
import com.example.labintentmvp.model.Offer
import com.example.labintentmvp.viewmodel.CouponViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.coupons_list_item.view.*

class CouponsRVAdapter (var couponViewModel: CouponViewModel):
    RecyclerView.Adapter<CouponsRVAdapter.CouponsViewHolder>() {

    private var couponsList: List<Offer>? = null

    fun setCouponsList(coupons: List<Offer>) {
        this.couponsList = coupons
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouponsViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding =
            DataBindingUtil.inflate(layoutInflater, viewType, parent, false)
        return CouponsViewHolder(binding)

    }

    override fun getItemCount(): Int = couponsList?.size ?: 0

    override fun onBindViewHolder(holder: CouponsViewHolder, position: Int) {
        holder.setCoupon(couponViewModel, position)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    private fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.coupons_list_item

    }


    class CouponsViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {


        private var binding: ViewDataBinding? = null

        init {
            this.binding = binding
        }

        fun setCoupon(couponViewModel: CouponViewModel, position: Int) {
            binding?.setVariable(BR.model, couponViewModel)
            binding?.setVariable(BR.position, position)
        }




    }


}