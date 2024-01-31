package com.example.islami

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class SuraAdabter(val suraNameList:List<String>): Adapter<SuraAdabter.SuraViewHolder>() {
    class SuraViewHolder(item:View):ViewHolder(item){
        var suraName:TextView=item.findViewById(R.id.tv_suraname_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.sura_name_item,parent,false)
        return SuraViewHolder(view)
    }

    override fun getItemCount(): Int {
        return suraNameList.size
    }
  var onSuraClick:OnItemClick?=null
    override fun onBindViewHolder(holder: SuraViewHolder, position: Int) {
        var suraList=suraNameList[position]
        holder.suraName.text=suraList
       holder.itemView.setOnClickListener{

           onSuraClick!!.onClick(suraList,position)
        }
    }
    interface OnItemClick{
        fun onClick(suraItem:String,index:Int)
    }
}