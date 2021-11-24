package com.duongnh.beertestdemo.ui.beer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.duongnh.beertestdemo.base.adapter.BaseAdapter
import com.duongnh.beertestdemo.databinding.BeerItemBinding
import com.duongnh.beertestdemo.models.BeerPresentation

class BeerAdapter: BaseAdapter<BeerPresentation, BeerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BeerViewHolder(
        BeerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        holder.bind(item(position))
    }
}