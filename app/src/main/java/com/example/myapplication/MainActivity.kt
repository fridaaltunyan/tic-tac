package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

open class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start = findViewById<Button>(R.id.btn_start)

        val firstPlayer = findViewById<TextView>(R.id.plaYer1)
        val secondPlayer = findViewById<TextView>(R.id.plaYer2)
//        val first=findViewById<EditText>(R.id.editTextTextPersonName)
//        val second = findViewById<EditText>(R.id.editTextTextPersonName2)
        start.setOnClickListener{

            val intent = Intent(this,Secondarily::class.java)
//            intent.putExtra("Name1","$first")
//            intent.putExtra("Name2","$second")
            startActivity(intent)
        }
        val getFirstPoints = intent.getStringExtra("Points1")
        val  getSecondPoints=intent.getStringExtra("Points2")
        firstPlayer.text = getFirstPoints.toString()
        secondPlayer.text = getSecondPoints.toString()


    }

}