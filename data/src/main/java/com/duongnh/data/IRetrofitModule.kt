package com.duongnh.data

interface IRetrofitModule {
    fun <S> createService(serviceClass: Class<S>): S
}