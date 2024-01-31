package com.example.islami.Adabters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.islami.R
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islami.Models.HadethDataModel

class HadethAdabter( var hadethList:MutableList<HadethDataModel>): Adapter<HadethAdabter.HadethViewHolder>() {
    class HadethViewHolder(item:View):ViewHolder(item){
        var hadethTitle:TextView=item.findViewById(R.id.tv_suraname_item)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.sura_name_item,parent,false)
        return HadethViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hadethList.size
    }
 var hadethClick: onItemClick? =null
    override fun onBindViewHolder(holder: HadethViewHolder, position: Int) {
       var hadethListBinding=hadethList[position]
       holder.hadethTitle.text=hadethListBinding.title
        holder.itemView.setOnClickListener{
            hadethClick!!.onclick(hadethListBinding,position)
        }
    }

    interface onItemClick{
        fun onclick(list:HadethDataModel,index:Int)
    }


}