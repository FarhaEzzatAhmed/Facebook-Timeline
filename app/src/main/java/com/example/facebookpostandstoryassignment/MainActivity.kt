package com.example.facebookpostandstoryassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    // late init m3naha ana h3ml initialise b3den [as 3ala mas2olitii
    lateinit var postRecyclerView : RecyclerView
    lateinit var storyRecyclerview :RecyclerView
    lateinit var adapter :TimelineAdapter
    lateinit var adapter2:StoryAdapter
    lateinit var postsList : ArrayList<TimelineData>
    lateinit var storyList :ArrayList<StoryData>
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postRecyclerView = findViewById(R.id.rv2)
        storyRecyclerview  = findViewById(R.id.rv1)
        initFacebookTimeline()
        initStory()
        adapter = TimelineAdapter(postsList)
        // b3d kada h3ml set ll adapter
        postRecyclerView.adapter=adapter

        adapter2 = StoryAdapter(storyList)

        storyRecyclerview.adapter =adapter2

        // lw 3ayza al ata tt3ard mn al a5r ll al awl hahot feh al lineal layout false
        linearLayoutManager = LinearLayoutManager(this)
        postRecyclerView.layoutManager =linearLayoutManager
    }
       fun initFacebookTimeline(){
        postsList = ArrayList()

        for (i in 0..1000){
            postsList.add(TimelineData("post Authour $i",R.drawable.person,"2h $i","post description",R.drawable.girl,"Like $i"))


        }


    }

    fun initStory(){
        storyList = ArrayList()
        for (i in 0..1000){
            storyList.add(StoryData(R.drawable.girl,R.drawable.person,"Post Authour $i"))

        }



    }
}