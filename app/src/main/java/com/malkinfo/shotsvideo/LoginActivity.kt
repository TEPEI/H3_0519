package com.malkinfo.shotsvideo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    // 選択肢
    private val spinnerItems = arrayOf("北海道"," 青森県"," 岩手県","宮城県"," 秋田県"," 山形県"," 福島県"," 茨城県"," 栃木県"," 群馬県"," 埼玉県"," 千葉県"," 東京都"," 神奈川県"," 新潟県"," 富山県"," 石川県"," 福井県"," 山梨県"," 長野県"," 岐阜県"," 静岡県"," 愛知県"," 三重県"," 滋賀県"," 京都府"," 大阪府"," 兵庫県"," 奈良県"," 和歌山県"," 鳥取県"," 島根県"," 岡山県"," 広島県"," 山口県"," 徳島県"," 香川県"," 愛媛県"," 高知県"," 福岡県"," 佐賀県"," 長崎県"," 熊本県"," 大分県"," 宮崎県"," 鹿児島県"," 沖縄県"
    )
    private val textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val userName = findViewById<EditText>(R.id.editTextTextPersonName)
        val password = findViewById<EditText>(R.id.editTextTextPassword)
        val manButton = findViewById<Button>(R.id.button)
        val womanButton = findViewById<Button>(R.id.button2)
        val otherButton = findViewById<Button>(R.id.button3)
        val sendButton = findViewById<Button>(R.id.registration)


        val spinner: Spinner = findViewById(R.id.spinnerArea)

        // ArrayAdapter

        // ArrayAdapter
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerItems)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // spinner に adapter をセット

        // spinner に adapter をセット
        spinner.setAdapter(adapter)

        // リスナーを登録

        // リスナーを登録
        spinner.setOnItemSelectedListener(object : OnItemSelectedListener {
            //　アイテムが選択された時
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                val spinner: Spinner = parent as Spinner
                //textView.setText(spinner.getSelectedItem())
            }

            //　アイテムが選択されなかった
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //
            }
        })


        // lambda式
        sendButton.setOnClickListener { v: View? ->
            val intent = Intent(application, MainActivity::class.java)
            startActivity(intent)
        }


    }
}