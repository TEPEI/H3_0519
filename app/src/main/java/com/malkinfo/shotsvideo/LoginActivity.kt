package com.malkinfo.shotsvideo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.malkinfo.shotsvideo.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

       val editText = findViewById<editText>(R.id.editTextTextPersonName)

    }


    /** Called when the user taps the Send button */
    fun sendMessage(view: View) {
        // Do something in response to button
    }


}