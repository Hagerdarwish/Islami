package com.example.islami.Fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami.Activities.DetailsAhadethActivity
import com.example.islami.Activities.DetailsQuranActivity
import com.example.islami.Adabters.HadethAdabter
import com.example.islami.Constants
import com.example.islami.Models.HadethDataModel
import com.example.islami.R
import com.example.islami.databinding.FragmentAhadethBinding
import com.google.android.material.datepicker.SingleDateSelector
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception


class AhadethFragment : Fragment() {
 var ahadeth = mutableListOf<HadethDataModel>()
lateinit var binding: FragmentAhadethBinding
    lateinit var adabter: HadethAdabter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAhadethBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readHadeth()
        initRecyclerview()
    }
    private fun initRecyclerview() {
        adabter=HadethAdabter(ahadeth)

        adabter.hadethClick=object :HadethAdabter.onItemClick{
            override fun onclick(list: HadethDataModel, index: Int) {
                var intent=Intent(activity,DetailsAhadethActivity::class.java)
                intent.putExtra(Constants.HADETH_TITLE,"${list.title}")
                intent.putExtra(Constants.HADETH_Content,"${list.content}")
                intent.putExtra(Constants.HADETH_INDEX,"${index}")
                Log.e("ahadeth","list is ${list} and index is ${index}")
                startActivity(intent)
            }

        }

        binding.rvAhadeth.adapter=adabter
    }
    private fun readHadeth():String {
        var fileContact =""

        try {
            val inputStream=requireActivity().assets.open("ahadeeth.txt")
            val reader = BufferedReader(InputStreamReader(inputStream))
            //all hedeth in one string
            var hadethes = reader.readText()
            // list of adadeth
           var hedethList:MutableList<String> = hadethes.split("#").toMutableList()
            // every hedeh in ahadeth
            for (hedeth in hedethList){
                var singleHadethWithSpace=hedeth.trim()
              var singleHadeth:MutableList<String> = singleHadethWithSpace.split("\n").toMutableList()
               var title = singleHadeth[0]

                singleHadeth.removeAt(0)
                var content=singleHadeth.joinToString(" "){
                    return@joinToString it
                }
                ahadeth.add(HadethDataModel(title,content))
                //Log.e("hedeth","sura name is ${}" )

            }


           // Log.e("DetailsQuranActivity","sura name is ${hedethList}" )
            inputStream.close()
        }catch (e: Exception){
            e.printStackTrace()
        }
        return fileContact
    }

    }
