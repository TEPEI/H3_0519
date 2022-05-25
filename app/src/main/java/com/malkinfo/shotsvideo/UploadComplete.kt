package com.malkinfo.shotsvideo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class UploadComplete : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_complete)


        val progressbar: ProgressBar = findViewById<ProgressBar>(R.id.progressBar)

        progressbar.setOnClickListener { v: View? ->
            val intent = Intent(application, UploadingActivity::class.java)
            startActivity(intent)
        }

    }
}
