package com.malkinfo.shotsvideo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle;
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.widget.SearchView

class ThemeUpActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_up)

        val sendButton = findViewById<Button>(R.id.buttonmain)

        val data = listOf(
            "あだち", "いのうえ", "うえき", "うえだ",
            "うえと", "うちだ", "うちの", "うつみ", "うの", "えとう", "おおた"
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


        // lambda式
        sendButton.setOnClickListener { v: View? ->
            val intent = Intent(application, ThemeAddActivity::class.java)
            startActivity(intent)
        }

    }
}