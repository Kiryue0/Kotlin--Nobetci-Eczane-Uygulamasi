package com.melih.eczaneuygulamasi

import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.navigation.NavDirections
import androidx.navigation.Navigation.findNavController
import com.melih.eczaneuygulamasi.databinding.FragmentFirstBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragment : BaseFragment<FragmentFirstBinding>(
    FragmentFirstBinding::inflate
) {
        var secilenSehir=String()
        var secilenİlce = String()

    override fun initView() {

        val spinner: Spinner = binding.spinner
        val iller = ArrayList<String>(resources.getStringArray(R.array.İl).toList())
        val toastMessage = resources.getString(R.string.secilen)
         spinnerYarat(iller, spinner, toastMessage)
    }

    fun spinnerYarat(List: ArrayList<String>, spinner: Spinner, toastString: String):String {
        var secilen = String()
        val adapter: ArrayAdapter<String> = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item, List
        )
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                positon: Int,
                id: Long
            ) {
                if (positon != 0 ) {
                    Toast.makeText(
                        requireContext(), "$toastString" + "" + "" + List[positon],
                        Toast.LENGTH_SHORT
                    ).show()
                     secilenSehir = List[positon]
                    ilcegetir(secilenSehir)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>) {}
        }
        return secilen
    }
    fun ilcegetir(il:String){
        val kdi = ApiUtils.getDistrictDao()
        val liste = ArrayList<String>()
        GlobalScope.launch {
            val ilceler = kdi.ilceler(il)
            ilceler.enqueue(object :Callback<DistrictGet>{
                override fun onResponse(call: Call<DistrictGet>, response: Response<DistrictGet>) {
                    response.body()?.districtList!!.forEach{
                        liste.add(it.district)
                    }
                    liste.add(0,"İlce Seciniz")
                    spinnerYaratIlce(liste,binding.spinner2,"Secilen İlce: ")
                    val gecis = FirstFragmentDirections.actionFirstToSecond(secilenSehir,secilenİlce)
                    binding.button.setOnClickListener {
                        findNavController(it).navigate(gecis)
                    }

                }

                override fun onFailure(call: Call<DistrictGet>, t: Throwable) {

                }
            })
        }
    }
    fun spinnerYaratIlce(List: ArrayList<String>, spinner: Spinner, toastString: String) {

        val adapter: ArrayAdapter<String> = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item, List
        )
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                positon: Int,
                id: Long
            ) {
                if (positon != 0 ) {
                    Toast.makeText(
                        requireContext(), "$toastString" + "" + "" + List[positon],
                        Toast.LENGTH_SHORT
                    ).show()
                    secilenİlce = List[positon]
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>) {}
        }
    }


    }




