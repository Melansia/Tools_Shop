package com.slt.toolsshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DrillDetailActivity : AppCompatActivity() {

    private lateinit var ivToolImage: ImageView
    private lateinit var tvToolName: TextView
    private lateinit var tvToolDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drill_detail)

        ivToolImage = findViewById(R.id.ivToolImage)
        tvToolName = findViewById(R.id.tvToolName)
        tvToolDescription = findViewById(R.id.tvToolDescription)

        val actionBar = supportActionBar
        actionBar?.hide()

        val intent = intent

        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resId")) {
            val title = intent.getStringExtra("title")
            val info = intent.getStringExtra("info")
            val resId = intent.getIntExtra("resId", -1)

            tvToolName.text = title
            tvToolDescription.text = info
            ivToolImage.setImageResource(resId)


        } else {
            val backToCategory = Intent(this, DrillCategoryActivity::class.java)
            startActivity(backToCategory)
        }

    }
}