package com.example.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.databinding.ActivityMainBinding
import layout.OscarMovie

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: OscarMovieAdapter
    private lateinit var b: ActivityMainBinding
    private val oscarMovieList: MutableList<OscarMovie> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        populateList()

        setUpAdapter()
    }

    private fun setUpAdapter() {

        adapter = OscarMovieAdapter(this, oscarMovieList)

        b.OscarMoviesRV.adapter = adapter
        b.OscarMoviesRV.layoutManager = LinearLayoutManager(this)
    }

    private fun populateList() {
        for (i in 1..15){
            val name = "Movie Name $i"
            val j = i - 1
            val director = "Director $j"

            val foodItem = OscarMovie(name = name, director = director)

            oscarMovieList.add(foodItem)
        }
    }
}
