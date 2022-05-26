package com.malkinfo.shotsvideo

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.malkinfo.shotsvideo.grid.CustomAdapter
import com.malkinfo.shotsvideo.model.Animal


class VideoUpActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_up)

        val animalList = listOf<Animal>(
            Animal(R.drawable.one, ""),
            Animal(R.drawable.two, ""),
            Animal(R.drawable.three, ""),
            Animal(R.drawable.four, ""),
            Animal(R.drawable.five,""),
            Animal(R.drawable.six,""),
            Animal(R.drawable.minestrone,"")
        )

        val recycler_view: RecyclerView = findViewById(R.id.recycler_view)

        recycler_view.adapter = CustomAdapter(animalList)
        recycler_view.layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
/*
        val previewButton: Button = findViewById<Button>(R.id.gallery)
        // lambda式
        previewButton.setOnClickListener { v: View? ->
            val intent = Intent(application, VideoPreviewActivity::class.java)
            startActivity(intent)
        }

 */

        recycler_view.addOnItemTouchListener(
            RecyclerItemClickListener(
                this,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View?, position: Int) {
                        // ここで処理
                        val intent = Intent(application, VideoPreviewActivity::class.java)
                        startActivity(intent)
                    }
                })
        )

        val randomPage: ImageView = findViewById<ImageView>(R.id.imageView3)
        val searchPage: ImageView = findViewById<ImageView>(R.id.imageView5)
        val uploadPage: ImageView = findViewById<ImageView>(R.id.imageView6)

        randomPage.setOnClickListener { v: View? ->
            val intent = Intent(application, MainActivity::class.java)
            startActivity(intent)
        }

        searchPage.setOnClickListener { v: View? ->
            val intent = Intent(application, ThemeUpActivity::class.java)
            startActivity(intent)
        }

        uploadPage.setOnClickListener { v: View? ->
            val intent = Intent(application, VideoUpActivity::class.java)
            startActivity(intent)
        }

    /*
        val cardview: CardView = findViewById<CardView>(R.id.card_view)

        cardview.setOnClickListener { v: View? ->
            val intent = Intent(application, VideoPreviewActivity::class.java)
            startActivity(intent)
        }

 */






    }
}