package com.malkinfo.shotsvideo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.TextView

class ThemeAddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_add)

        val sendButton = findViewById<Button>(R.id.buttonregistoration)

        var textMessage = findViewById<TextView>(R.id.text_message)

        var buttonReg = findViewById<Button>(R.id.buttonregistoration)


        buttonReg.setOnClickListener{
            textMessage.setText(R.string.text_message_complete)
        }

        // lambda式
        sendButton.setOnClickListener { v: View? ->
            val intent = Intent(application, ThemeUpActivity::class.java)
            startActivity(intent)



            //mSwitchの状態が変化した際のリスナ
            var buttonReg = findViewById<Button>(R.id.button5)


            buttonReg.setOnClickListener{
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(R.id.blankfragment, BlankFragment.createInstance())
                transaction.addToBackStack(null)
                transaction.commit()
            }

        }
    }
}