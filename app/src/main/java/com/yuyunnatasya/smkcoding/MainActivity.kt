package com.yuyunnatasya.smkcoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_list_movie.onClick {
         //   toast("Daftar Film Woyyyy")
           // val intent =
           //     Intent(this@MainActivity, ListMovieActivity::class.java)
          //  startActivity(intent)

           startActivity(intentFor<ListMovieActivity>())
        }
    }
}
