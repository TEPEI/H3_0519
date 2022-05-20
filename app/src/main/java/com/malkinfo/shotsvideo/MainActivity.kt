package com.malkinfo.shotsvideo

import android.R
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.malkinfo.shotsvideo.adapter.VideoAdapter
import com.malkinfo.shotsvideo.model.VideoModel


class MainActivity : AppCompatActivity() {

    lateinit var viewPager2:ViewPager2
    lateinit var adapter:VideoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**set fullscreen*/
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN)

        /**set find id*/
        viewPager2 = findViewById(R.id.vpager)

        /**set database*/
        // Create a storage reference from our app
        //val storage = FirebaseStorage.getInstance()
        //var storageRef = storage.reference

        val mDataBase = Firebase.database.getReference("video")

        val options = FirebaseRecyclerOptions.Builder<VideoModel>()
            .setQuery(mDataBase,VideoModel::class.java)
            .build()
        /**set adapter*/
        adapter = VideoAdapter(options)
        viewPager2.adapter = adapter

        val returnButton: Button = findViewById(R.id.return_button)
        // lambda式
        // lambda式
        returnButton.setOnClickListener { v -> finish() }

    }

    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }
   
    
}

