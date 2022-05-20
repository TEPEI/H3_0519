package com.malkinfo.shotsvideo

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
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

        //initializeResource()

        val bnv = findViewById<BottomNavigationView>(R.id.bottomBar)

        bnv.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_random -> {
                    //setFragment()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.action_themeSep -> {
                    //setFragment()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.action_themeUp -> {
                    //setFragment()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.action_videoUp -> {
                    //setFragment()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })

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

        //val returnButton: Button = findViewById<Button>(R.id.return_button)
        // lambda式
        // lambda式
        //returnButton.setOnClickListener { v -> finish() }

    }

    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }


    /*
    fun initializeResource(){
        //BottomNavigationViewを設定
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomBar)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        bottomNavigationView.itemIconSize = 70
        bottomNavigationView.scaleX = 1.2f
        bottomNavigationView.scaleY = 1.2f




    }
   
    */
}

