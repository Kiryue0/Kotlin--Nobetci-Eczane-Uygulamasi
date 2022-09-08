package com.melih.eczaneuygulamasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.melih.eczaneuygulamasi.databinding.FragmentThirdBinding
import com.melih.eczaneuygulamasi.util.LocationsConstant


class ThirdFragment : BaseFragment<FragmentThirdBinding>(
    FragmentThirdBinding::inflate
){

    override fun initView() {

        val bundle:ThirdFragmentArgs by navArgs()


        val eczaneAd = bundle.eczaneAd
        val eczaneAdres = bundle.eczaneAdres
        val eczaneNumara = bundle.eczaneNumara
        val eczaneLoc = bundle.eczaneLoc
        val eczaneIlce = bundle.eczaneIlce
        binding.textViewAd.text = "Ad: $eczaneAd"
        binding.textViewTel.text = "Telefon: $eczaneNumara"
        binding.textViewAdres.text = "Adres: $eczaneAdres"
        binding.textViewilce.text = "İlce: $eczaneIlce"

        LocationsConstant.location = eczaneLoc
        LocationsConstant.name = eczaneAd


    }



}