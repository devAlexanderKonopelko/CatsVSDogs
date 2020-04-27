package com.example.catsvsdogs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        startButton.setOnClickListener {
            if (firstName.text.toString().isNotEmpty() && secondName.text.toString().isNotEmpty()) {
                DataStorage.instance.player1Name = firstName.text.toString()
                DataStorage.instance.player2Name = secondName.text.toString()
                firstName.text?.clear()
                secondName.text?.clear()

                DataStorage.instance.player1Points = 0
                DataStorage.instance.player2Points = 0

                val intent = Intent(this, GameActivity::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Enter all players names", Toast.LENGTH_SHORT).show()
            }
        }
    }


}
