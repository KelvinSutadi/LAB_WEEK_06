package com.example.lab_week_06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recycler_view) }

    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object : CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) {
                showSelectionDialog(cat)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male, CatBreed.BalineseJavanese, "Fred", "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female, CatBreed.ExoticShorthair, "Wilma", "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown, CatBreed.AmericanCurl, "Curious George", "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Male, CatBreed.ExoticShorthair, "Leo", "Loves to nap in the sun",
                    "https://cdn2.thecatapi.com/images/55p.jpg"
                ),
                CatModel(
                    Gender.Female, CatBreed.BalineseJavanese, "Luna", "Very playful and energetic",
                    "https://cdn2.thecatapi.com/images/47s.jpg"
                ),
                CatModel(
                    Gender.Male, CatBreed.AmericanCurl, "Milo", "A true gentleman",
                    "https://cdn2.thecatapi.com/images/aob.jpg"
                ),
                CatModel(
                    Gender.Female, CatBreed.ExoticShorthair, "Chloe", "Queen of the house",
                    "https://cdn2.thecatapi.com/images/d3u.jpg"
                ),
                CatModel(
                    Gender.Male, CatBreed.BalineseJavanese, "Simba", "Brave and adventurous",
                    "https://cdn2.thecatapi.com/images/bje.jpg"
                ),
                CatModel(
                    Gender.Female, CatBreed.AmericanCurl, "Nala", "Loves belly rubs",
                    "https://cdn2.thecatapi.com/images/MTc1Mjg4MA.jpg"
                ),
                CatModel(
                    Gender.Unknown, CatBreed.ExoticShorthair, "Shadow", "Mysterious and shy",
                    "https://cdn2.thecatapi.com/images/cq4.jpg"
                )
            )
        )
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .show()
    }
}