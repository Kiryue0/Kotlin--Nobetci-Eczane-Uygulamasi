package com.melih.eczaneuygulamasi

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.melih.eczaneuygulamasi.databinding.FragmentMapsBinding
import com.melih.eczaneuygulamasi.databinding.FragmentThirdBinding

class  MapsFragment :  BaseFragment<FragmentMapsBinding>(
    FragmentMapsBinding::inflate
) {


    override fun initView() {


    }
}