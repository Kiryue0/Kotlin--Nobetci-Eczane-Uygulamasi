package com.melih.eczaneuygulamasi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import com.melih.eczaneuygulamasi.databinding.FragmentFirstBinding
import kotlin.reflect.typeOf

class FirstFragment : BaseFragment<FragmentFirstBinding>(
    FragmentFirstBinding::inflate
) {

    override fun initView() {
        val spinner:Spinner = binding.spinner
        val iller = resources.getStringArray(R.array.İl)
        val toastMessage = resources.getString(R.string.secilen)
        val spinner2:Spinner = binding.spinner2
        spinnerYarat(iller,spinner,toastMessage)
        spinnerYarat(iller,spinner2,toastMessage)

        binding.button.setOnClickListener{
            findNavController(it).navigate(R.id.action_first_to_second) }
    }














}