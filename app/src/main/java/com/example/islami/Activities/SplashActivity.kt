package com.example.islami.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.islami.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initScreen()
    }

    private fun initScreen() {
       Handler(Looper.getMainLooper()).postDelayed({
           var intent=Intent(this, HomeActivity::class.java)
           startActivity(intent)
       },2000)
        finish()

    }
}