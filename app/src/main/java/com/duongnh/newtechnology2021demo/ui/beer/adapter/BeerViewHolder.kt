package com.duongnh.newtechnology2021demo.ui.beer.adapter

import coil.load
import coil.transform.CircleCropTransformation
import com.duongnh.newtechnology2021demo.R
import com.duongnh.newtechnology2021demo.base.adapter.BaseViewHolder
import com.duongnh.newtechnology2021demo.databinding.BeerItemBinding
import com.duongnh.newtechnology2021demo.models.BeerPresentation

class BeerViewHolder(private val binding: BeerItemBinding): BaseViewHolder(binding) {
    fun bind(beer: BeerPresentation?){
        binding.textName.text = beer?.name
        binding.textTagline.text = beer?.tagline
        val size = binding.root.resources.getDimension(R.dimen.size_image_beer).toInt()
        binding.imgBeer.load(beer?.imageUrl){
            size(size, size)
            crossfade(true)
            placeholder(R.drawable.image_place_holder)
            transformations(CircleCropTransformation())
            error(R.drawable.image_place_holder)
        }
    }
}