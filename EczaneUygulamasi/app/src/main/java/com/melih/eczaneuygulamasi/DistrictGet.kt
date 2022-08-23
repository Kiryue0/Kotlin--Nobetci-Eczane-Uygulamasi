package com.melih.eczaneuygulamasi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DistrictGet(
    @SerializedName("result")@Expose var districtList:List<District>,
    @SerializedName("success")@Expose var success:Boolean
) {
}