package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Secondarily: MainActivity() {
    private var buttons = Array(3) { Array(3) { "" } }
    private lateinit var textViewPlayer1: TextView
    private lateinit var textViewPlayer2: TextView
    private var player1Turn: Boolean = true
 private lateinit var btnRes: Button
    private var temp = "X"
    private var roundCount: Int = 0
    private var player2Points: Int = 0
    private var player1Points: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secondlayout)
        val back = findViewById<Button>(R.id.butback)
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Points1","$player1Points")
            intent.putExtra("Points2","$player2Points")
            startActivity(intent)
        }
        textViewPlayer1 = findViewById(R.id.player1)
        textViewPlayer2 = findViewById(R.id.player2)
        btnRes= findViewById(R.id.button_reset)
        btnRes.setOnClickListener {
            player1Points = 0
            player2Points = 0
            updateScore()

        }
    }
   fun onBtnClick(view:View) {
       val btn: Button = view as Button
        if (btn.text == "" && temp == "X") {
            btn.text= "X"
            when (btn.id) {
                R.id.button2 -> {
                    buttons[0][0] = btn.text.toString()
                }
                R.id.button3-> {
                    buttons[0][1] = btn.text.toString()
                }
                R.id.button4 -> {
                    buttons[0][2] = btn.text.toString()
                }
                R.id.button5 -> {
                    buttons[1][0] = btn.text.toString()
                }
                R.id.button6 -> {
                    buttons[1][2] = btn.text.toString()
                }
                R.id.button7 -> {
                    buttons[1][1] = btn.text.toString()
                }
                R.id.button8 -> {
                    buttons[2][0] = btn.text.toString()
                }
                R.id.button9 -> {
                    buttons[2][1] = btn.text.toString()
                }
                R.id.button10 -> {
                    buttons[2][2] = btn.text.toString()
                }
            }

        } else if (btn.text == "" && temp == "0" )
        {
            btn.text = "O"
            when (btn.id) {
                R.id.button2 -> {
                    buttons[0][0] = btn.text.toString()
                }
                R.id.button3-> {
                    buttons[0][1] = btn.text.toString()
                }
                R.id.button4 -> {
                    buttons[0][2] = btn.text.toString()
                }
                R.id.button5 -> {
                    buttons[1][0] =btn.text.toString()
                }
                R.id.button6 -> {
                    buttons[1][2] = btn.text.toString()
                }
                R.id.button7 -> {
                    buttons[1][1] = btn.text.toString()
                }
                R.id.button8 -> {
                    buttons[2][0] = btn.text.toString()
                }
                R.id.button9 -> {
                    buttons[2][1] = btn.text.toString()
                }
                R.id.button10 -> {
                    buttons[2][2] =btn.text.toString()
                }
            }
        }
//        if(btn.text != "") return
//        if(player1Turn){
//            btn.text= "X"
//        }else{
//            btn.text = "O"
//        }
        roundCount++

        if(checkForWin(buttons)){
            if(player1Turn) win(1) else win(2)
        }else if(roundCount == 9){
            draw()
        }else player1Turn = !player1Turn
    }
   private fun checkForWin(arr: Array<Array<String>>) : Boolean{

        for(i in 0..2){
            if((arr[i][0] == arr[i][1])&&
                (arr[i][0] == arr[i][2])&&
                (arr[i][0] != ""))
                return true
        }

        for(i in 0..2){
            if(
                (arr[0][i] == arr[1][i])&&
                (arr[0][i] == arr[2][i])&&
                (arr[0][i] != "")
            )
                return true
        }

        if(
            (arr[0][0] == arr[1][1])&&
            (arr[0][0] == arr[2][2])&&
            (arr[0][0] != "")
        ) return true

        if(
            (arr[0][2] == arr[1][1])&&
            (arr[0][2] == arr[2][0])&&
            (arr[0][2] != "")
        ) {
            return true
        }

        return false

    }
    private fun win(player:Int){
        if(player == 1) player1Points++ else player2Points++
        Toast.makeText(
            applicationContext,
            "Player $player Won!",
            Toast.LENGTH_SHORT).show()

    }
    private fun draw( vararg arr: Array<String>): Boolean {

            Toast.makeText(
                    applicationContext, "Match Draw!",
                    Toast.LENGTH_SHORT).show()
        for(i in 0..2) for(j in 0..2){
            if(arr[i][j] == ""){
                return false
            }
        }
        return true

    }
@SuppressLint("SetTextI18n")
private  fun updateScore(){
    textViewPlayer1.text = "Player 1: $player1Points"
    textViewPlayer2.text = "Player 2: $player2Points"
}
    }

