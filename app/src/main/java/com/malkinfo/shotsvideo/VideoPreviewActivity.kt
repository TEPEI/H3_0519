package com.malkinfo.shotsvideo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class VideoPreviewActivity : AppCompatActivity() {

    private val spinnerItems = arrayOf("","CocaCola","ミネストローネ","FE参考書")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_preview)

        val spinner: Spinner = findViewById(R.id.spinnerTheme)

        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerItems)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // spinner に adapter をセット

        // spinner に adapter をセット
        spinner.setAdapter(adapter)

        // リスナーを登録

        // リスナーを登録
        spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
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

        val confirmButton: Button = findViewById<Button>(R.id.uploadConfirm)
        // lambda式
        confirmButton.setOnClickListener { v: View? ->
            val intent = Intent(application, UploadComplete::class.java)
            startActivity(intent)
        }

        val cancelButton: Button = findViewById<Button>(R.id.uploadCancel)
        // lambda式
        cancelButton.setOnClickListener { v: View? ->
            val intent = Intent(application, VideoUpActivity::class.java)
            startActivity(intent)
        }

        val videoView: VideoView = findViewById(R.id.previewVideo)

        videoView.setVideoURI(Uri.parse("https://firebasestorage.googleapis.com/v0/b/h3-kaihatsu.appspot.com/o/674639838.357586.mp4?alt=media&token=0a4afdba-9e05-49f8-b2f0-87f66f6b2fe4"))

        videoView.start()

    }
}