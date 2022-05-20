package com.malkinfo.shotsvideo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.malkinfo.shotsvideo.R
import android.content.Intent
import android.view.View
import android.widget.Button
import com.malkinfo.shotsvideo.MainActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val sendButton = findViewById<Button>(R.id.registration)
        // lambda式
        sendButton.setOnClickListener { v: View? ->
            val intent = Intent(application, MainActivity::class.java)
            startActivity(intent)
        }
    }
}