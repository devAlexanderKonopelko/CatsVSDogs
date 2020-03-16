package com.example.catsvsdogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_fragment_dogs.*

class FragmentDogs : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_fragment_dogs, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        playerDogs.text = DataStorage.instance.player2Name

        clickDogs.setOnClickListener {
            DataStorage.instance.player2Points += 1
            textDogs.text = DataStorage.instance.player2Name

        }
    }

}
