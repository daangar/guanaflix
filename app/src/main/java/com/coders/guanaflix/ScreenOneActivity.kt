package com.coders.guanaflix

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coders.guanaflix.databinding.ActivityScreenOneBinding

class ScreenOneActivity: AppCompatActivity() {

    private val binding by lazy {
        ActivityScreenOneBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        savedInstanceState?.let { bundle ->
            val user = bundle.getString(USER_KEY, "")
            val password = bundle.getString(PASSWORD_KEY, "")
            binding.etUser.setText(user)
            // algo
            binding.etPassword.setText(password)
        }

        binding.btnGoToScreenTwo.setOnClickListener {
            val intent = Intent(this, ScreenTwoActivity::class.java)
            intent.putExtra(USER_KEY, binding.etUser.text.toString())
            intent.putExtra(PASSWORD_KEY, binding.etPassword.text.toString())
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(USER_KEY, binding.etUser.text.toString())
        outState.putString(PASSWORD_KEY, binding.etPassword.text.toString())
        super.onSaveInstanceState(outState)
    }

    companion object {
        const val USER_KEY = "user_key"
        const val PASSWORD_KEY = "password_key"
    }
}