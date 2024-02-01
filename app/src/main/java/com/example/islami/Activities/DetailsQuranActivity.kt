package com.example.islami.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.islami.Constants
import com.example.islami.R
import com.example.islami.databinding.ActivityDetailsQuranBinding
import com.example.islami.databinding.ActivityHomeBinding
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception

import kotlin.properties.Delegates
import kotlin.text.StringBuilder

class DetailsQuranActivity : AppCompatActivity() {
 lateinit var sura_name:String
    lateinit var sura_index:String
    lateinit var binding:ActivityDetailsQuranBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailsQuranBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sura_index= intent.getStringExtra(Constants.SURA_INDEX)!!
        sura_name=intent.getStringExtra(Constants.SURA_NAME)!!

        Log.e("DetailsQuranActivity","sura name is ${sura_name} and index is ${sura_index}")
        binding.tvsuraTitle.text=sura_name
        binding.tvsuraAyat.text= readFile()
    }

    private fun readFile():String {
        var fileContact =""
        try {
            val inputStream=assets.open(sura_index)
            val reader = BufferedReader(InputStreamReader(inputStream))
            var filename = reader.readLines()
            fileContact=filename.joinToString(separator = " "){
               var index=filename.indexOf(it)
                return@joinToString it +"{${++index}}"
            }
            Log.e("DetailsQuranActivity","sura name is ${filename} and index is ${sura_index}")
            inputStream.close()
        }catch (e:Exception){
            e.printStackTrace()
        }
return fileContact
    }
}