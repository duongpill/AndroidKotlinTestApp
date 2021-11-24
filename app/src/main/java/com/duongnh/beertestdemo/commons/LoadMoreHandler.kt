package com.duongnh.beertestdemo.commons

import android.util.Log

class LoadMoreHandler(
    private var totalItem: Int,
    private val totalItemInPage: Int,
    private val onScroll: (page: Int) -> Unit
) {
    private var currentRow = 0
    private var currentPage = 1
    private var isLoadingData = false
    private var endPage = false

    fun canScroll(position: Int) {
        Log.d("LoadMoreHandler", "isLoadingData: $isLoadingData, endRow: $endPage")
        if (!isLoadingData && !endPage) {
            currentRow = (position + 1) / totalItemInPage + 1
            if (currentRow > 1) {
                Log.i("LoadMoreHandler", "currentPage: $currentPage")
                isLoadingData = true
                currentPage += 1
                onScroll.invoke(currentPage)
            }
        }
    }

    fun refresh(totalItem: Int, endPage: Boolean) {
        this.totalItem =  totalItem
        this.isLoadingData = false
        this.endPage = endPage
    }
}