package com.hemangmaan.zooapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class animalDescriptions : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_descriptions)

        val bundle:Bundle? = intent.extras
        val name = bundle?.get("name")
        val des = bundle?.get("des")
        val image = bundle?.get("Image")
        var img = findViewById<ImageView>(R.id.ivImage)
        var name1 = findViewById<TextView>(R.id.tvName1)
        var des1 = findViewById<TextView>(R.id.tvDes1)
        img.setImageResource(image as Int)
        name1.text = name as String
        des1.text = des as String
    }

}