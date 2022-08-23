package com.melih.eczaneuygulamasi

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(private val mContext:Context,private val pharmacyList:List<OrnekSınıf> )
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
        val name = pharmacyList[position]
        holder.satirPharmacyName.text = name.ad
    }

    override fun getItemCount(): Int {
        return pharmacyList.size
    }
}