package com.example.catsvsdogs

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_finish.*

class FinishFragment : Fragment(), View.OnClickListener {

    @Override
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_finish, container, false)
    }

    @SuppressLint("SetTextI18n")
    @Override
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val instance = DataStorage.instance
        when {
            instance.player1Points > instance.player2Points -> {
                winnerNameFinish.text = instance.player1Name.toString()
                winnerScoreFinish.text = getString(R.string.finish_fragment_winner_scope) + ": " +
                        instance.player1Points.toString()
            }
            instance.player1Points < instance.player2Points -> {
                winnerNameFinish.text = instance.player2Name.toString()
                winnerScoreFinish.text = getString(R.string.finish_fragment_winner_scope) + ": " +
                        instance.player2Points.toString()
            }
            else -> {
                winnerNameFinish.text = getString(R.string.finish_fragment_winner_draw)
                winnerScoreFinish.text = getString(R.string.finish_fragment_winner_scope) + ": " +
                        instance.player1Points.toString()
            }
        }

        startAgainFinish.setOnClickListener(this)
        historyFinish.setOnClickListener(this)
    }

    @Override
    override fun onClick(v: View?) {
        when (v?.id) {
            historyFinish.id -> {
                val intent = Intent(activity, HistoryActivity::class.java)
                startActivity(intent)
            }
            startAgainFinish.id -> {

                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
