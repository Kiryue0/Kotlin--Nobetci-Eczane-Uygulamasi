package com.melih.eczaneuygulamasi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PharmacyDao {
    @GET("dutyPharmacy")
    fun eczaneler(@Query("il") il:String,@Query("ilce") ilce: String): Call<PharmacyGet>
}