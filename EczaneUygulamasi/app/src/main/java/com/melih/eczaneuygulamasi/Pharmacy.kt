package com.melih.eczaneuygulamasi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Pharmacy(
    @SerializedName("name")@Expose var pharmacyName:String,
    @SerializedName("dist")@Expose var pharmacyDist:String,
    @SerializedName("address")@Expose var pharmacyAddress:String,
    @SerializedName("phone")@Expose var pharmacyPhone:String,
    @SerializedName("loc")@Expose var pharmacyLoc:String
    ) {
}