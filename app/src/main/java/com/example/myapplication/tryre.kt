package com.example.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityTryreBinding
import recycler_view_pack.Movie
import recycler_view_pack.MyAdapter

class tryre : AppCompatActivity() {
    private lateinit var trybinding: ActivityTryreBinding
    private lateinit var adapter: MyAdapter // Class-level adapter variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        trybinding = ActivityTryreBinding.inflate(layoutInflater)
        setContentView(trybinding.root)

        // Set up the toolbar
        trybinding.toolbar.title = "Movie App"
        setSupportActionBar(trybinding.toolbar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initial list of movies
        val movies = listOf(
            Movie("Venom", "This is a short description of the movie Venom.", R.drawable.download),
            Movie("Spider-Man", "This is a short description of the movie Spider-Man.", R.drawable.download)
        ,  Movie("Venom", "This is a short description of the movie Venom.", R.drawable.download),
            Movie("Spider-Man", "This is a short description of the movie Spider-Man.", R.drawable.download)
,  Movie("Venom", "This is a short description of the movie Venom.", R.drawable.download),
            Movie("Spider-Man", "This is a short description of the movie Spider-Man.", R.drawable.download)
,  Movie("Venom", "This is a short description of the movie Venom.", R.drawable.download),
            Movie("Spider-Man", "This is a short description of the movie Spider-Man.", R.drawable.download)
,  Movie("Venom", "This is a short description of the movie Venom.", R.drawable.download),
            Movie("Spider-Man", "This is a short description of the movie Spider-Man.", R.drawable.download)

        )

        // Set up RecyclerView
        adapter = MyAdapter()
        adapter.updateItems(movies)
        trybinding.rvMovies.layoutManager = LinearLayoutManager(this)
        trybinding.rvMovies.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.more -> {
                val moreMovies = listOf(
                    Movie("Iron Man", "This is a short description of the movie Iron Man.", R.drawable.download),
                    Movie("Thor", "This is a short description of the movie Thor.", R.drawable.download),
                    Movie("Black Panther", "This is a short description of the movie Black Panther.", R.drawable.download)
               ,                    Movie("Iron Man", "This is a short description of the movie Iron Man.", R.drawable.download),
                    Movie("Thor", "This is a short description of the movie Thor.", R.drawable.download),
                    Movie("Black Panther", "This is a short description of the movie Black Panther.", R.drawable.download)
,                    Movie("Iron Man", "This is a short description of the movie Iron Man.", R.drawable.download),
                    Movie("Thor", "This is a short description of the movie Thor.", R.drawable.download),
                    Movie("Black Panther", "This is a short description of the movie Black Panther.", R.drawable.download)
,                    Movie("Iron Man", "This is a short description of the movie Iron Man.", R.drawable.download),
                    Movie("Thor", "This is a short description of the movie Thor.", R.drawable.download),
                    Movie("Black Panther", "This is a short description of the movie Black Panther.", R.drawable.download)
,                    Movie("Iron Man", "This is a short description of the movie Iron Man.", R.drawable.download),
                    Movie("Thor", "This is a short description of the movie Thor.", R.drawable.download),
                    Movie("Black Panther", "This is a short description of the movie Black Panther.", R.drawable.download)
                            ,Movie("Iron Man", "This is a short description of the movie Iron Man.", R.drawable.download),
                Movie("Thor", "This is a short description of the movie Thor.", R.drawable.download),
                Movie("Black Panther", "This is a short description of the movie Black Panther.", R.drawable.download)
              ,  Movie("Iron Man", "This is a short description of the movie Iron Man.", R.drawable.download),
                Movie("Thor", "This is a short description of the movie Thor.", R.drawable.download),
                Movie("Black Panther", "This is a short description of the movie Black Panther.", R.drawable.download)

                )
                adapter.updateItems(moreMovies)
                Toast.makeText(this, "More movies added!", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
