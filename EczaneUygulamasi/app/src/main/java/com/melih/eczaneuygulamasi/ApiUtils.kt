package com.melih.eczaneuygulamasi

import retrofit2.create

class ApiUtils {
    companion object{
        val BASE_URL="https://api.collectapi.com/health/"

        fun getPharmacyDao():PharmacyDao{

            return RetrofitClient.getClient(BASE_URL).create(PharmacyDao::class.java)
        }
        fun getDistrictDao():DistrictDao{
            return RetrofitClient.getClient(BASE_URL).create(DistrictDao::class.java)
        }
    }
}