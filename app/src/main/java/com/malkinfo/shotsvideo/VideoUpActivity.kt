package com.malkinfo.shotsvideo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.malkinfo.shotsvideo.grid.CustomAdapter
import com.malkinfo.shotsvideo.model.Animal


class VideoUpActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_up)

        val animalList = listOf<Animal>(
            Animal(R.drawable.one, "ネコ"),
            Animal(R.drawable.two, "イヌ"),
            Animal(R.drawable.three, "ゴリラ"),
            Animal(R.drawable.four, "ウマ"),
            Animal(R.drawable.five,"キノコ"),
            Animal(R.drawable.six,"アドギャヴォ")
        )

        val recycler_view: RecyclerView = findViewById(R.id.recycler_view)

        recycler_view.adapter = CustomAdapter(animalList)
        recycler_view.layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)

        val previewButton: Button = findViewById<Button>(R.id.gallery)
        // lambda式
        previewButton.setOnClickListener { v: View? ->
            val intent = Intent(application, VideoPreviewActivity::class.java)
            startActivity(intent)
        }

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