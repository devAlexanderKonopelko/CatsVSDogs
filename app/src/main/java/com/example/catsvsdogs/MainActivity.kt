package com.example.catsvsdogs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        startButton.setOnClickListener {
            DataStorage.instance.player1Name = firstName.text.toString()
            DataStorage.instance.player2Name = secondName.text.toString()
            firstName.text?.clear()
            secondName.text?.clear()

            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
    }


}
