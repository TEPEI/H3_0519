package com.malkinfo.shotsvideo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RelativeLayout

class UploadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uploading)

        val returnButton: RelativeLayout = findViewById<RelativeLayout>(R.id.success)

        returnButton.setOnClickListener { v: View? ->
            val intent = Intent(application, VideoUpActivity::class.java)
            startActivity(intent)
        }

    }
}