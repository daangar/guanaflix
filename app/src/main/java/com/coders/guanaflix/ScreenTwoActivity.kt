package com.coders.guanaflix

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScreenTwoActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_two)
        intent.extras?.let { bundle ->
            val user = bundle.getString(ScreenOneActivity.USER_KEY, "....")
            val password = bundle.getString(ScreenOneActivity.PASSWORD_KEY, "....")
            //otro comentario
            findViewById<TextView>(R.id.tvUserName).text = getString(R.string.saludo, user, password)

        }
    }
}