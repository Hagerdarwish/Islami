package com.example.islami.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami.Activities.DetailsQuranActivity
import com.example.islami.Constants
import com.example.islami.Adabters.SuraAdabter
import com.example.islami.databinding.FragmentQuranBinding


class QuranFragment : Fragment() {

lateinit var adabter: SuraAdabter
lateinit var binding:FragmentQuranBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentQuranBinding.inflate(inflater,container,false)
        return binding.root
    }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       super.onViewCreated(view, savedInstanceState)
        adabter= SuraAdabter(Constants.allSuraList)

       adabter.onSuraClick=object: SuraAdabter.OnItemClick{
           override fun onClick(suraItem: String, index: Int) {

               var intent=Intent(activity,DetailsQuranActivity::class.java)
              intent.putExtra(Constants.SURA_INDEX,"${index +1}.txt")
             intent.putExtra(Constants.SURA_NAME,"${suraItem}")

               startActivity(intent)


           }


       }

        binding.rvSura.adapter=adabter

    }


}