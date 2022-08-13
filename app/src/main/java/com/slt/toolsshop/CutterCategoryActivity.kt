package com.slt.toolsshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class CutterCategoryActivity : AppCompatActivity() {


    private lateinit var lvCutters: ListView

    private var cutters: ArrayList<Cutter>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cutter_category)
        supportActionBar?.hide()

        cutters = ArrayList()
        cutters!!.add(
            Cutter(
                getString(R.string.cutters_unior_title),
                getString(R.string.cutters_unior_info),
                R.drawable.unior_utters
            )
        )
        cutters!!.add(
            Cutter(
                getString(R.string.cutters_knipex_title),
                getString(R.string.cutters_knipex_info),
                R.drawable.knipex_cutters
            )
        )
        cutters!!.add(
            Cutter(
                getString(R.string.cutters_dewalt_title),
                getString(R.string.cutters_dewalt_info),
                R.drawable.dewalt_cutters
            )
        )

        lvCutters = findViewById(R.id.lvCutters)


        val adapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, cutters!!)
        lvCutters.adapter = adapter

        lvCutters.setOnItemClickListener { parent, view, position, id ->
            val cutter = cutters!![position]
            val intent = Intent(applicationContext, DrillDetailActivity::class.java)
            intent.putExtra("title", cutter.title)
            intent.putExtra("info", cutter.info)
            intent.putExtra("resId", cutter.imageResource)
            startActivity(intent)
        }
    }
}