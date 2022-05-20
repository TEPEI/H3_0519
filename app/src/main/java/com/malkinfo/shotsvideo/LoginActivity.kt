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
    private val spinnerItems = arrayOf("", "Android", "Apple", "Windows")
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