package com.slt.toolsshop

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class DrillCategoryActivity : AppCompatActivity() {

    private lateinit var lvDrills: ListView

    private var drills: ArrayList<Drill>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drill_category)
        supportActionBar?.hide()

        drills = ArrayList()
        drills!!.add(
            Drill(
                getString(R.string.drill_interskol_title),
                getString(R.string.drill_interskol_info),
                R.drawable.interskol
            )
        )
        drills!!.add(
            Drill(
                getString(R.string.drill_makita_title),
                getString(R.string.drill_makita_info),
                R.drawable.makita
            )
        )
        drills!!.add(
            Drill(
                getString(R.string.drill_dewalt_title),
                getString(R.string.drill_dewalt_info),
                R.drawable.dewalt
            )
        )

        lvDrills = findViewById(R.id.lvDrills)


        val adapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, drills!!)
        lvDrills.adapter = adapter
        
        lvDrills.setOnItemClickListener { parent, view, position, id ->
            val drill = drills!![position]
            val intent = Intent(applicationContext, DrillDetailActivity::class.java)
            intent.putExtra("title", drill.title)
            intent.putExtra("info", drill.info)
            intent.putExtra("resId", drill.imageResource)
            startActivity(intent)

        }
    }
}
