package com.coders.guanaflix.presentation.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.coders.guanaflix.data.repositories.FakeRepository
import com.coders.guanaflix.data.repositories.Repository
import com.coders.guanaflix.databinding.ActivityHomeBinding
import kotlinx.coroutines.launch

class HomeActivity: AppCompatActivity() {

    private val binding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }



    private lateinit var repository: Repository

    private val showsAdapter by lazy {
        ShowsAdapter(
            itemClicked = { name ->
                showToast(name)
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()
        repository = FakeRepository()
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            val data = repository
                .getData()
            showsAdapter.addShows(data)
        }
    }

    private fun setupRecyclerView() {
        with (binding.rvShows) {
            layoutManager = GridLayoutManager(
                this@HomeActivity,
                3
            )
            adapter = showsAdapter
        }
    }

    private fun showToast(showName: String) {
        Toast.makeText(
            this,
            "has hecho click en: $showName",
            Toast.LENGTH_LONG
        ).show()
    }
}