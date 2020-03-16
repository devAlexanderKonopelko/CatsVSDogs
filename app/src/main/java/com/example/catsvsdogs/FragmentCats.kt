package com.example.catsvsdogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_fragment_cats.*
import kotlinx.android.synthetic.main.activity_fragment_dogs.*

class FragmentCats : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        playerCats.text = DataStorage.instance.player1Name

        clickCats.setOnClickListener {
            DataStorage.instance.player1Points += 1
            textCats.text = DataStorage.instance.player1Name
        }
    }

}
