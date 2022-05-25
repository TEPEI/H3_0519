package com.malkinfo.shotsvideo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class UploadComplete : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_complete)


        val return_button: Button = findViewById<Button>(R.id.returnFromComplete)

        return_button.setOnClickListener { v: View? ->
            val intent = Intent(application, VideoUpActivity::class.java)
            startActivity(intent)
        }

    }
}
