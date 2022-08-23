package com.melih.eczaneuygulamasi

import android.util.Log
import androidx.navigation.Navigation
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
         lateinit var orneklerList:ArrayList<OrnekSınıf>
         lateinit var adapter:RVAdapter
        binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())

        val ornek1 = OrnekSınıf("1. Eczane")
        val ornek2 = OrnekSınıf("2. Eczane")
        val ornek3 = OrnekSınıf("3. Eczane")
        orneklerList = ArrayList<OrnekSınıf>()
        orneklerList.add(ornek1)
        orneklerList.add(ornek2)
        orneklerList.add(ornek3)
        adapter = RVAdapter(requireContext(),orneklerList)
        binding.recyclerview.adapter = adapter

        binding.button2.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_secondFragment_to_maps)
    }
        manisaSehirler()
    }

    fun manisaSehirler(){
        val kdi = ApiUtils.getDistrictDao()

        GlobalScope.launch {
            val ilceler = kdi.manisailceler("Manisa")
            ilceler.enqueue(object : Callback<DistrictGet>{
                override fun onResponse(call: Call<DistrictGet>, response: Response<DistrictGet>) {
                  for (ilce in response.body()?.districtList!!)
                      Log.d("Ilceler", "onResponse: ${ilce.district}" )
                }

                override fun onFailure(call: Call<DistrictGet>, t: Throwable) {
                }
            })
        }

    }

}




