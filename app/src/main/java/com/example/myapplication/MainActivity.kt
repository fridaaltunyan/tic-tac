package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

open class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val go = findViewById<Button>(R.id.butgo)

        val firstPlayer = findViewById<TextView>(R.id.plaYer1)
        val secondPlayer = findViewById<TextView>(R.id.plaYer2)
        firstPlayer.text= intent.getStringExtra("Points1").toString()
        secondPlayer.text= intent.getStringExtra("Points2").toString()
        go.setOnClickListener{
            val intent = Intent(this,Secondarily::class.java)
            startActivity(intent)
        }
    }
}