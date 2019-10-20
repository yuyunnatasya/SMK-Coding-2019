package com.yuyunnatasya.smkcoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.yuyunnatasya.smkcoding.database.DatabaseContract
import com.yuyunnatasya.smkcoding.model.ResultsItem
import com.yuyunnatasya.smkcoding.database.database
import kotlinx.android.synthetic.main.activity_detail_movie.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class DetailMovieActivity : AppCompatActivity() {

    var isMovieFavorite : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val movie = intent.getParcelableExtra<ResultsItem>("model")

        tv_title_movie.text = movie.title
        tv_rating_movie.text = "Rating : ${movie.popularity}"
        tv_description_movie.text = movie.overview
        Glide.with(this).load("https://image.tmdb.org/t/p/w500" + movie?.posterPath)
            .into(iv_poster_movie)

        // cek dulu
        checkMovieFavorite(movie)

        button_favorite.onClick {
            //    checkMovieFavorite(movie)

            if (isMovieFavorite) {
                deleteMovieFromFavorite(movie)
            } else {
                addMovieToFavorite(movie)
            }

        }
    }
    private fun deleteMovieFromFavorite(movie: ResultsItem?){
        database.use{
            delete(ResultsItem.TABLE_FAVORITE,
                "${ResultsItem.COLUMN_TITLE} = {title}",
                "title" to movie?.title.toString()
                )
            toast("movie di hapus dari daftar favorit")
            isMovieFavorite = false
            button_favorite.text = "tambah favorite"
        }
    }

    private fun addMovieToFavorite(movie: ResultsItem?) {
        database.use{
            insert(ResultsItem.TABLE_FAVORITE,
                ResultsItem.COLUMN_TITLE to movie?.title,
                ResultsItem.COLUMN_POSTERPATH to movie?.posterPath,
                ResultsItem.COLUMN_RATING to movie?.popularity,
                ResultsItem.COLUMN_DESCRIPTION to movie?.overview)
            toast("berhasil di tambahkan ke favorite")

            isMovieFavorite = true
            button_favorite.text = "hapus favorite"
        }
    }

    private fun checkMovieFavorite(movie: ResultsItem?) {
    //Todo pengecekan film ini sudah favorite atau belum
        database.use {
           var isFavorite = select(ResultsItem.TABLE_FAVORITE,ResultsItem.COLUMN_TITLE)
                .whereArgs(ResultsItem.COLUMN_TITLE+"={title}" ,
                    "title" to movie?.title.toString())
            val dataMovie : DatabaseContract?
            = isFavorite.parseOpt(classParser<DatabaseContract>())

            Log.d("FAVORITMOVIE", dataMovie.toString())

            if (dataMovie!=null){
                isMovieFavorite = true
                button_favorite.text = "hapus favorite"
            }else{
                isMovieFavorite = false
                button_favorite.text = "tambah favorite"
            }


        }
    }
}

    private fun addMovieToFavorite(movie: ResultsItem?) {

    }

    private fun deleteMovieFromFavorite(movie: ResultsItem?) {

    }

