package com.malkinfo.shotsvideo.grid


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.malkinfo.shotsvideo.R
import com.malkinfo.shotsvideo.VideoPreviewActivity
import com.malkinfo.shotsvideo.model.Animal
import androidx.appcompat.app.AppCompatActivity
import android.app.Application
import android.widget.*
import org.w3c.dom.NodeList
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory


class CustomAdapter(private val animalList: List<Animal>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image_view)
        val name: TextView = view.findViewById(R.id.text_view)
        //val button: Button = view.findViewById((R.id.button_view))
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.grid_items, viewGroup, false)
        val holder = ViewHolder(view)
        //CardViewにリスナーを設定
        holder.itemView.findViewById<CardView>(R.id.card_view).setOnClickListener {
            val position = holder.getAdapterPosition();


        }
        return holder
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val animal = animalList[position]
        viewHolder.image.setImageResource(animal.image)
        viewHolder.name.text = animal.name

    }

    override fun getItemCount() = animalList.size

}

