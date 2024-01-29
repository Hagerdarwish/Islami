package com.example.islami.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islami.Fragments.AhadethFragment
import com.example.islami.Fragments.QuranFragment
import com.example.islami.Fragments.RadioFragment
import com.example.islami.Fragments.SebhaFragment
import com.example.islami.R
import com.example.islami.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.setOnItemSelectedListener {
            if(it.itemId==R.id.ic_quran){
                supportFragmentManager.beginTransaction().replace(R.id.fragment,QuranFragment(),"").commit()
            }else if (it.itemId==R.id.ic_ahadeth){
                supportFragmentManager.beginTransaction().replace(R.id.fragment,AhadethFragment(),"").commit()
            }else if (it.itemId==R.id.ic_sebha){
                supportFragmentManager.beginTransaction().replace(R.id.fragment, SebhaFragment(),"").commit()
            }else if (it.itemId==R.id.ic_radio){
                supportFragmentManager.beginTransaction().replace(R.id.fragment,RadioFragment(),"").commit()
            }
            return@setOnItemSelectedListener true
        }
    }

}