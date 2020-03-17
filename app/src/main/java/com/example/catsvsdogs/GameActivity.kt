package com.example.catsvsdogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.timer_fragment_layout.*

class GameActivity : AppCompatActivity(), View.OnClickListener {
    private val fragmentCats = FragmentCats()
    private val fragmentDogs = FragmentDogs()
    private val fragmentTimer = FragmentTimer()
    private val fragmentFinish = FinishFragment()
    private var time = 15

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        startGameButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            startGameButton.id -> {
                DataStorage.instance.player1Points = 0
                DataStorage.instance.player2Points = 0

                supportFragmentManager.beginTransaction().replace(fragmentCatsWidget.id, fragmentCats)
                    .commit()

                supportFragmentManager.beginTransaction().replace(fragmentTimerWidget.id, fragmentTimer)
                    .commit()

                supportFragmentManager.beginTransaction().replace(fragmentDogsWidget.id, fragmentDogs)
                    .commit()

                startGameButton.visibility = View.INVISIBLE

                val timer = object: CountDownTimer((time*1000).toLong(), 1000) {
                    override fun onFinish() {
                        time = 0
                        finishGame()
                    }

                    override fun onTick(millisUntilFinished: Long) {
                        fragmentTimer.timerView.text = "$time"
                        time--
                    }

                }.start()
            }
        }
    }

    private fun finishGame() {
        if (time == 0) {
            supportFragmentManager.beginTransaction().remove(fragmentCats)
                .commit()

            supportFragmentManager.beginTransaction().remove(fragmentTimer)
                .commit()

            supportFragmentManager.beginTransaction().remove(fragmentDogs)
                .commit()

            supportFragmentManager.beginTransaction().replace(fragmentFinishWidget.id, fragmentFinish)
                .commit()

            val instance = DataStorage.instance
            instance.addHistory(instance.player1Name.toString(), instance.player1Points)
            instance.addHistory(instance.player2Name.toString(), instance.player2Points)
        }
    }
}