package com.malkinfo.shotsvideo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ThemeAddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_add)

        val sendButton = findViewById<Button>(R.id.buttonregistoration)

        // lambda式
        sendButton.setOnClickListener { v: View? ->
            val intent = Intent(application, ThemeUpActivity::class.java)
            startActivity(intent)


            mSwitch = (Switch)findViewById(R.id.switch);

            //mSwitchの状態が変化した際のリスナ
            mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(mSwitch.isChecked()) {
                        //mSwitch : Off -> On の時の処理
                    } else {
                        //mSwitch : On -> Off の時の処理
                    }
                }
            });
        }
    }
}