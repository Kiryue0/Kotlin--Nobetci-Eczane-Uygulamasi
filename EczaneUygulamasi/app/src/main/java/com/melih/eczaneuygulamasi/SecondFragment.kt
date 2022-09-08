package com.melih.eczaneuygulamasi

import android.util.Log
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.melih.eczaneuygulamasi.databinding.FragmentSecondBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SecondFragment :BaseFragment<FragmentSecondBinding>(
    FragmentSecondBinding::inflate
) {

    override fun initView() {
        val bundle:SecondFragmentArgs by navArgs()
        val sehir = bundle.gelenSehir
        val ilce = bundle.gelenilce
        eczanegetir(sehir,ilce)


    }

    fun eczanegetir(il:String,ilce: String) {
        val kdi = ApiUtils.getPharmacyDao()

        GlobalScope.launch {
            val eczaneler = kdi.eczaneler(il,ilce)
            eczaneler.enqueue(object : Callback<PharmacyGet> {
                override fun onResponse(call: Call<PharmacyGet>, response: Response<PharmacyGet>) {

                    lateinit var adapter:RVAdapter
                    binding.recyclerview.setHasFixedSize(true)
                    binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
                    adapter = RVAdapter(requireContext(),response.body()?.pharmacieList!!)
                    binding.recyclerview.adapter = adapter



                }

                override fun onFailure(call: Call<PharmacyGet>, t: Throwable) {

                }
            })
        }

    }




}




