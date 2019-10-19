package com.yuyunnatasya.smkcoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_list_movie.*

class ListMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_movie)

        viewpager.adapter = TabLayoutAdapter(supportFragmentManager, this)
        tablayout.setupWithViewPager(viewpager)

    }
}
