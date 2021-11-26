package com.duongnh.beertestdemo.commons

class LoadMoreHandler(
    private val totalItemInPage: Int,
    private val onScroll: (page: Int) -> Unit
) {
    private var currentRow = 0
    private var currentPage = 1
    private var isLoadingData = false
    private var endPage = false

    fun canScroll(position: Int) {
        if (!isLoadingData && !endPage) {
            currentRow = (position + 1) / totalItemInPage + 1
            if (currentRow > 1) {
                isLoadingData = true
                currentPage += 1
                onScroll.invoke(currentPage)
            }
        }
    }

    fun refresh(endPage: Boolean) {
        this.isLoadingData = false
        this.endPage = endPage
    }
}