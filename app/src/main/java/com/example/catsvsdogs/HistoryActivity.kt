package com.example.catsvsdogs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val adapter =
            ArrayAdapter<String>(this, R.layout.history_item, DataStorage.instance.getHistoryList())
        listViewWidget.adapter = adapter

        listViewWidget.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val intent = Intent(view?.context, HistoryActivity::class.java)
                intent.putExtra("NAME", parent?.getItemAtPosition(position).toString())
                startActivity(intent)
            }
    }
}
