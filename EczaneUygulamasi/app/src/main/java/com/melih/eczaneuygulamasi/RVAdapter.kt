package com.melih.eczaneuygulamasi

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(private val mContext:Context,private val pharmacyGet:List<Pharmacy> )
    :RecyclerView.Adapter<RVAdapter.CardView>() {

    inner class CardView(view:View):RecyclerView.ViewHolder(view){

        var satirCardView:androidx.cardview.widget.CardView
        var satirPharmacyName:TextView
        var pharmacyİmage:ImageView
        var arrow:ImageView

        init{
            satirCardView= view.findViewById(R.id.satirCardview)
            satirPharmacyName=view.findViewById(R.id.textviewName)
            pharmacyİmage = view.findViewById(R.id.imageLogo)
            arrow = view.findViewById(R.id.imageArrow)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardView {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.cardview_tasarim,parent,false)
        return CardView(tasarim)
    }

    override fun onBindViewHolder(holder: CardView, position: Int) {
        val name = pharmacyGet[position]
        holder.satirPharmacyName.text = name.pharmacyName

        val gecis = SecondFragmentDirections.actionSecondToThird(eczaneAd = name.pharmacyName, eczaneIlce = name.pharmacyDist, eczaneAdres = name.pharmacyAddress, eczaneNumara = name.pharmacyPhone, eczaneLoc = name.pharmacyLoc)

        holder.satirCardView.setOnClickListener{
            Navigation.findNavController(it).navigate(gecis)
        }
    }

    override fun getItemCount(): Int {
        return pharmacyGet.size
    }
}