package com.melih.eczaneuygulamasi

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.melih.eczaneuygulamasi.databinding.ActivityMainBinding
import com.melih.eczaneuygulamasi.util.LocationsConstant
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var liste:List<District>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = "Nöbetçi Eczane Bul"
        setSupportActionBar(binding.toolbar)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_maps->{
                if(LocationsConstant.location != null){

                   val eczaneurl = Uri.parse("https://www.google.co.in/maps/dir/"+Uri.decode(LocationsConstant.location))
                    val mapIntent = Intent(Intent.ACTION_VIEW,eczaneurl)
                    mapIntent.setPackage("com.google.android.apps.maps")
                    startActivity(mapIntent)

                }
                else{
                    Toast.makeText(applicationContext,"Lütfen öncelikle gitmek istediğiniz eczaneyi seçiniz!!",Toast.LENGTH_SHORT).show()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }


}

