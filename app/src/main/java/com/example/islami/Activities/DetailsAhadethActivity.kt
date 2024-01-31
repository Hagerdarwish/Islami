package com.example.islami.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islami.Constants
import com.example.islami.R
import com.example.islami.databinding.ActivityDetailsAhadethBinding

class DetailsAhadethActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsAhadethBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailsAhadethBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var hadethTitle=intent.getStringExtra(Constants.HADETH_TITLE)
        var hadethContent=intent.getStringExtra(Constants.HADETH_Content)

        binding.tvhadethTitle.text=hadethTitle
        binding.tvhadethHadeth.text=hadethContent
    }
}