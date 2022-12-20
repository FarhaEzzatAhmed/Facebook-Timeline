package com.example.facebookpostandstoryassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class TimelineAdapter(
val posts : ArrayList<TimelineData>?
) : RecyclerView.Adapter<TimelineAdapter.TimelineViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimelineViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        // ana mhtag view w2t aal runtime hato mn al item
        //bhot false 3lshan ana 3ayza yd5ol feh al on bind l2no lw mad5alsh hykarr naf al data
        val view = inflater.inflate(R.layout.item,parent,false)

        // b3d kada hb3t al view ll view holder
        return TimelineViewHolder(view)
    }

    override fun onBindViewHolder(holder: TimelineViewHolder, position: Int) {
        //!! hatet dol l2n m3naha lw l2tha b null 5alas msh hykaml w yd5ol 3ala ali b3daha
        val postItem = posts?.get(position)!!
        holder.profilePicture .setImageResource(postItem?.postAuthourImage?:R.drawable.person)
        holder.uploadTime.text=postItem?.uploadData
        holder.name.text=postItem?.postAuthor
        //: alii b3deha ana hna bhoto 3lshan lw b null hotlii al sora de
        holder.postImage.setImageResource(postItem?.postImage?:R.drawable.person)
        holder.postdescription.text=postItem?.postDescription
        holder.likeButton.text = postItem?.like


    }

    override fun getItemCount(): Int {
        //low la2tha b null 5aliha b zeroo
        return  posts?.size?: 0
    }



    // al view holder dh alii mas2ol 3an al view bta3 al item y3nii dh alii bdii feh al id bta3 kol item
    class TimelineViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView){

        // awl ma ynadii 3ala l function bta3t al constracture hyd5ol 3ala init
        var postImage : ImageView
        var profilePicture : ImageView
        var uploadTime: TextView
        var name: TextView
        var postdescription: TextView
        var likeButton : Button
        init {
            postImage = itemView.findViewById(R.id.postImg)
            uploadTime = itemView.findViewById(R.id.time)
            name = itemView.findViewById(R.id.username)
            postdescription = itemView.findViewById(R.id.description)
            likeButton = itemView.findViewById(R.id.like)
            profilePicture = itemView.findViewById(R.id.person)

        }
    }


}