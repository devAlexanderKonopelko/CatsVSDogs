package com.example.catsvsdogs

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_fragment_cats.*


class FragmentCats : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_fragment_cats, container, false)
    }

    private lateinit var rocketAnimation: AnimationDrawable

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        playerCats.text = DataStorage.instance.player1Name

        val rocketImage = animationsCats.apply {
            setBackgroundResource(R.drawable.catcat)
            rocketAnimation = background as AnimationDrawable
        }
        rocketAnimation.start()

        clickCats.setOnClickListener {
            DataStorage.instance.player1Points += 1
            textCats.text = DataStorage.instance.player1Points.toString()
        }
    }
}
