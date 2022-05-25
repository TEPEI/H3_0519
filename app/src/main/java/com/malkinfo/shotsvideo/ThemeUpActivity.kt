package com.malkinfo.shotsvideo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle;
import android.view.View
import android.widget.*
import androidx.appcompat.widget.SearchView

class ThemeUpActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_up)

        val sendButton = findViewById<Button>(R.id.buttonmain)

        val data = listOf(
            "Coca Cola", "ポカリスウェット", "ミネストローネ", "星の王子さま","南アルプスの天然水","ミンティア","ブラックニッカ",
            "Jack Daniel","JMC", "アサヒスーパードライ", "CTC"
        )

        // ListViewにデータをセットする
        val list = findViewById<ListView>(R.id.List)
        list.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            data
        )

        // テキストフィルターを有効にする
        list.isTextFilterEnabled = true

        findViewById<SearchView>(R.id.search).setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                // 入力テキストに変更があったとき
                override fun onQueryTextChange(p0: String?): Boolean {
                    if (p0.isNullOrBlank()) {
                        list.clearTextFilter()
                    } else {
                        list.setFilterText(p0)
                    }
                    return false
                }
                // 検索ボタンを押したとき
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return false
                }
            }
        )
        // OnItemClickListenerを実装
        list.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(application, MainActivity::class.java)
            startActivity(intent)
        }

        // lambda式
        sendButton.setOnClickListener { v: View? ->
            val intent = Intent(application, ThemeAddActivity::class.java)
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


    }
}