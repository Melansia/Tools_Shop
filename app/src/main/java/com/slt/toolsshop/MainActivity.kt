package com.slt.toolsshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var lvTools: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar = supportActionBar
        actionBar?.hide()

        lvTools = findViewById(R.id.lvTools)
        lvTools.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            when (position) {
                0 -> {
                    val intent = Intent(applicationContext, DrillCategoryActivity::class.java)
                    startActivity(intent)
                }
            }
            Toast.makeText(applicationContext, "Position: $position", Toast.LENGTH_SHORT).show()
        })
    }
}