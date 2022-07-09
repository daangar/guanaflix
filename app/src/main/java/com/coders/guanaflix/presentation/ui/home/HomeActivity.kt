package com.coders.guanaflix.presentation.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.coders.guanaflix.databinding.ActivityHomeBinding

class HomeActivity: AppCompatActivity() {

    private val binding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        with (binding.rvShows) {
//            layoutManager = LinearLayoutManager(
//                this@HomeActivity,
//                LinearLayoutManager.HORIZONTAL,
//                false
//            )
            layoutManager = GridLayoutManager(
                this@HomeActivity,
                3
            )
            adapter = ShowsAdapter(
                showNames = getShows(),
                itemClicked = { name ->
                    showToast(name)
                }
            )
        }
    }

    private fun getShows(): List<String> {
        return listOf(
            "Under the dome",
            "Stranger things",
            "Obi wan kenobi",
            "The boys",
            "Ms Marvel",
            "Pedro el escamoso",
            "Betty la fea",
            "Casa de papel K-drama"
        )
    }

    private fun showToast(showName: String) {
        Toast.makeText(
            this,
            "has hecho click en: $showName",
            Toast.LENGTH_LONG
        ).show()
    }
}