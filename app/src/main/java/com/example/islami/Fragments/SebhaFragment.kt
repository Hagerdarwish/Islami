package com.example.islami.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami.R
import com.example.islami.databinding.FragmentSebhaBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class SebhaFragment : Fragment() {
 var count:Int=0
    private val texts = arrayOf("سبحان الله", "الحمد لله", "الله أكبر")
    private var currentIndex = 0
   lateinit var binding: FragmentSebhaBinding

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentSebhaBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment

        binding.frameAzkar.setOnClickListener{
            sebhaCounter()
            binding.tvCount.text=count++.toString()
            //  rotate the img
            binding.imgSebha.rotation+=90f

        }
        return binding.root
    }
    fun sebhaCounter(){
        if (count % 33 == 0) {
            currentIndex = (currentIndex + 1) % texts.size
            Log.e("current index","current index is ${currentIndex} and text.size is ${texts.size}")
            binding.tvAzkar.text = texts[currentIndex]
        }
    }


}