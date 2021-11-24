package com.duongnh.beertestdemo.base.adapter

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<DataType: BaseObject, ViewHolderType: BaseViewHolder>: RecyclerView.Adapter<ViewHolderType>() {
    //region Variable
    protected open val differ: AsyncListDiffer<DataType> by lazy {
        AsyncListDiffer(this, object: DiffUtil.ItemCallback<DataType>() {
            override fun areItemsTheSame(oldItem: DataType, newItem: DataType): Boolean {
                return this@BaseAdapter.areItemsTheSame(oldItem, newItem)
            }

            override fun areContentsTheSame(oldItem: DataType, newItem: DataType): Boolean {
                return this@BaseAdapter.areContentsTheSame(oldItem, newItem)
            }
        })
    }
    //endregion

    //region Override
    override fun getItemCount(): Int = differ.currentList.size
    //endregion

    fun areItemsTheSame(oldItem: DataType, newItem: DataType) = oldItem.id == newItem.id
    fun areContentsTheSame(oldItem: DataType, newItem: DataType) = oldItem == newItem

    fun bind(data: List<DataType>?, callback: Runnable ?= null){
        differ.submitList(data, callback)
    }

    fun add(data: DataType, callback: Runnable ?= null) {
        val modifyData = differ.currentList.toMutableList()
        modifyData.add(data)
        differ.submitList(modifyData, callback)
    }

    fun removeLast(callback: Runnable ?= null) {
        val modifyData = differ.currentList.toMutableList()
        if (modifyData.isNotEmpty()){
            modifyData.removeLast()
            differ.submitList(modifyData, callback)
        }else{
            callback?.run()
        }
    }

    fun add(data: List<DataType>, isBind: Boolean = false, callback: Runnable ?= null) {
        if (isBind){
            bind(data, callback)
        }else{
            val mutableData = differ.currentList.toMutableList()
            mutableData.addAll(data)
            differ.submitList(mutableData, callback)
        }
    }

    fun size() = differ.currentList.size
    fun data(): List<DataType> = differ.currentList
    fun item(pos: Int): DataType? = if (pos >= 0 && pos < size()) differ.currentList[pos] else null
}