package com.duongnh.data

interface IRetrofitClient {
    fun <S> createService(serviceClass: Class<S>): S
}