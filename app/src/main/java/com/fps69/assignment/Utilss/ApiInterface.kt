package com.fps69.assignment.Utilss

import com.fps69.assignment.DataClass.Reward

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("reward.php")
    fun getRewards(): Call<List<Reward>>
}