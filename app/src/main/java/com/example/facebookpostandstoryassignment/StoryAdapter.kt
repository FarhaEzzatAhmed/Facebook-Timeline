package com.example.facebookpostandstoryassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class StoryAdapter(
    val storyies :ArrayList<StoryData>?
):RecyclerView.Adapter<StoryAdapter.StoryViewHolder> (){


    class StoryViewHolder(val itemView : View):RecyclerView.ViewHolder(itemView){
        var backgroundImg : ImageView
        var topImg :ImageView
        var textname:TextView
        init {
            backgroundImg = itemView.findViewById(R.id.background)
            topImg = itemView.findViewById(R.id.top_img)
            textname =itemView.findViewById(R.id.text)
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
    val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.story_item,parent,false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val storyItem = storyies?.get(position)!!
        holder.backgroundImg.setImageResource(storyItem?.storyImg?:R.drawable.like)
        holder.topImg.setImageResource(storyItem?.topImg?:R.drawable.person)
        holder.textname.text=storyItem?.personName
    }

    override fun getItemCount(): Int {
        return storyies?.size?:0
    }
}