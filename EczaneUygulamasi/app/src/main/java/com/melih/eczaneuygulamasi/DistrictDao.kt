package com.melih.eczaneuygulamasi

import androidx.fragment.app.Fragment
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface DistrictDao {

    @GET("districtList")
    fun ilceler(@Query("il") adres:String):Call<DistrictGet>
}