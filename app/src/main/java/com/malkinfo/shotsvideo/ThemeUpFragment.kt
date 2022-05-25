package com.malkinfo.shotsvideo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThemeUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThemeUpFragment : Fragment() {

    companion object {
        fun createInstance(): ThemeUpFragment {
            return ThemeUpFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_theme_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val buttonprev = view.findViewById<Button>(R.id.buttonregistoration)
        buttonprev.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
    }}