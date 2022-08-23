package com.melih.eczaneuygulamasi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class District(@SerializedName("text")@Expose var district:String) {
}