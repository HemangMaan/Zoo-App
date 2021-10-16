package com.hemangmaan.zooapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var listOfAnimals = ArrayList<Animal>()
    private var adapter:AnimalsAdapter ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //load animals
        listOfAnimals.add(Animal("Fox","Fox is most clever animal of all",R.drawable.fox))
        listOfAnimals.add(Animal("Bear","Bear lives in Forests and contains lots of furs which prevents it from all types of weathers.",R.drawable.bear))
        listOfAnimals.add(Animal("Lion","Lion is the king of forest and is considered the most powerful animal. No other animal hunts the lion.",R.drawable.lion))
        listOfAnimals.add(Animal("Tiger","Tiger is the family of cats and lives in the forest it runs very fast to catch the prey but is gets tired fast too.",R.drawable.tiger))
        adapter = AnimalsAdapter(this, listOfAnimals)
        val listView = findViewById<ListView>(R.id.tvListAnimal)
        listView.adapter = adapter
    }

    class AnimalsAdapter(private var context: Context, private var listOfAnimals: ArrayList<Animal>) : BaseAdapter() {
        override fun getCount(): Int {
            return listOfAnimals.size
        }

        override fun getItem(p0: Int): Any {
            return listOfAnimals[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val animal = listOfAnimals[p0]
            val layoutInflater = context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val myView = layoutInflater.inflate(R.layout.animal_layout, null)
            val name = myView.findViewById(R.id.tvName) as TextView
            val des = myView.findViewById(R.id.tvDes) as TextView
            val imageView = myView.findViewById(R.id.ivName) as ImageView
            name.text = animal.name
            des.text = animal.des
            imageView.setImageResource(animal.image!!)
            imageView.setOnClickListener{
                val intent = Intent(context,animalDescriptions::class.java)
                intent.putExtra("name",animal.name)
                intent.putExtra("des",animal.des)
                intent.putExtra("Image",animal.image)
                context.startActivity(intent)
            }
            return myView
        }

    }
}