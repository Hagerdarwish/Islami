package com.example.islami.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami.Models.HadethDataModel
import com.example.islami.R
import com.google.android.material.datepicker.SingleDateSelector
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception


class AhadethFragment : Fragment() {
 var ahadeth = mutableListOf<HadethDataModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ahadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readHadeth()
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
