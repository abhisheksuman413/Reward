package com.fps69.assignment.Utilss

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiUtilities {

    private const val BASE_URL = "https://workholicpraveen.in/"

    fun getApiInterface(): ApiInterface {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}