package com.yuyunnatasya.smkcoding


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.hanifabdullah21.smkcoding.Movie
import com.yuyunnatasya.smkcoding.connection.ConfigRetrofit
import com.yuyunnatasya.smkcoding.connection.MovieInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_movie.view.*

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {

    lateinit var rootView : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        rootView = inflater.inflate(R.layout.fragment_movie, container, false)

        getListMovie()

       /* val list = Movie.listMovie as ArrayList<MovieModel>

        val layoutmanager = LinearLayoutManager(activity)

        val adapter = MovieAdapter(list,activity!!.applicationContext)

        return rootView.rv_movie.apply {
           layoutManager  = layoutmanager
            setAdapter(adapter)*/
        return rootView

        }

        private fun getListMovie(){
            val movieNowPlaying =
                ConfigRetrofit.retrofitConfig()
                .create(MovieInterface::class.java)
                .getListMovieNowPlaying(
                    "5077b7011a7ba8f19075a6343f8dcd8c")

            movieNowPlaying
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({response->
                    // menerima respone yang berhasil


                    val list = response.results
                    val layoutmanager = LinearLayoutManager(activity)

                    val adapter = MovieAdapter(list,activity!!.applicationContext)


                    rootView.rv_movie.apply {
                        layoutManager = layoutManager
                        setAdapter(adapter)
                    }

                },{
                    // menerima respone yang gagal
                })

    }
}
