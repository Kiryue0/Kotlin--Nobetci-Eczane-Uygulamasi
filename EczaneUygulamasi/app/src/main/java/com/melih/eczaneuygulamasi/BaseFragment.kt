package com.melih.eczaneuygulamasi
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.IllegalArgumentException

abstract class BaseFragment<VB: ViewBinding>(
    private val bindingInflater: (infalet:LayoutInflater)->VB
) :Fragment(){

        private var _binding:VB? =null
         val binding: VB get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater)
        if(_binding == null)
            throw IllegalArgumentException("Binding cannot be null")
            return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    abstract fun initView()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun spinnerYarat(List:Array<String>,spinner: Spinner,toastString:String){

            val adapter:ArrayAdapter<String> = ArrayAdapter(requireContext(),
                android.R.layout.simple_spinner_item,List)
            spinner.adapter =adapter

            spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>, view:View?, positon:Int, id:Long)
                { if(positon!=0){
                    Toast.makeText(requireContext(), "$toastString"+ ""+""+List[positon],
                        Toast.LENGTH_SHORT).show()}
                }
                override fun onNothingSelected(p0: AdapterView<*>) {
                }
    }}
}