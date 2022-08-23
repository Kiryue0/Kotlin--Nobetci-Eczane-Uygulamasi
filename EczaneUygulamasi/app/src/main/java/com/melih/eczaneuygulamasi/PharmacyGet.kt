package com.melih.eczaneuygulamasi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PharmacyGet(
    @SerializedName("result")@Expose var pharmacieList:List<Pharmacy>,
    @SerializedName("success")@Expose var success:Boolean,
) {
}