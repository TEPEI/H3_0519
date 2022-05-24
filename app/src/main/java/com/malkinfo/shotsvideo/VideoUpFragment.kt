package com.malkinfo.shotsvideo

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VideoUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VideoUpFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var imageView: ImageView? = null

    private val activeFragment: Fragment = VideoUpFragment()


    var resultLauncher: ActivityResultLauncher<*> = registerForActivityResult(
        StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            if (data != null) {
                val bitmap: Bitmap?
                // cancelしたケースも含む
                if (data.extras == null) {
                    Log.d("debug", "cancel ?")
                    return@registerForActivityResult
                } else {
                    bitmap = data.extras!!["data"] as Bitmap?
                    if (bitmap != null) {
                        // 画像サイズを計測
                        val bmpWidth = bitmap.width
                        val bmpHeight = bitmap.height
                        Log.d("debug", String.format("w= %d", bmpWidth))
                        Log.d("debug", String.format("h= %d", bmpHeight))
                    }
                }
                imageView?.setImageBitmap(bitmap)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        val bnv = view?.findViewById<BottomNavigationView>(R.id.bottomBar)

        if (bnv != null) {
            bnv.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.action_random -> {
                        //setFragment()
                        changeFragment(View())
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.action_themeSep -> {
                        //setFragment()
                        changeFragment(View())
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.action_themeUp -> {
                        //setFragment()
                        //changeFragment(ThemeUpFragment())
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.action_videoUp -> {
                        //setFragment()
                        changeFragment(VideoUpFragment())
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            })
        }

        imageView = view?.findViewById(R.id.image_view)

        val cameraButton: Button? = view?.findViewById(R.id.camera_button)
        // lambda式
        // lambda式
        if (cameraButton != null) {
            cameraButton.setOnClickListener { v ->
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                resultLauncher.launch(intent as Nothing?)
            }
        }

    }

    fun changeFragment(fragment: Fragment) {
        fragmentManager?.beginTransaction()?.hide(activeFragment)?.commit()
        fragmentManager?.beginTransaction()?.show(fragment)?.commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video_up, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment VideoUpFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VideoUpFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}