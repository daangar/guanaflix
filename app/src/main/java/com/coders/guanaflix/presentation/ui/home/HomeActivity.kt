package com.coders.guanaflix.presentation.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coders.guanaflix.databinding.ActivityHomeBinding

class HomeActivity: AppCompatActivity() {

    private val binding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}