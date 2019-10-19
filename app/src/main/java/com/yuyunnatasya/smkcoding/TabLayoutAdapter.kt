package com.yuyunnatasya.smkcoding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class TabLayoutAdapter
    (fm : FragmentManager, context: Context)
    : FragmentStatePagerAdapter(fm)
{
    override fun getItem(position: Int): Fragment {
       val movieFragment = MovieFragment()

        val bundle = Bundle()
        when(position){
            0 -> bundle.putString ("KEY" , "MOVIE")
            1 -> bundle.putString ("KEY" , "TV")
        }

        movieFragment.arguments = bundle

        return movieFragment
    }
    // adapter adalah jembatan untuk menghubungkan antara tampilan dan apa yang akan di isi
    override fun getCount(): Int { // bertanya kembali berapa yang akan di input
    return 2 // mengatakan kembali klo yg di input itu 2

    }

    override fun getPageTitle(position: Int): CharSequence? {
        return super.getPageTitle(position)
        return when (position){
            0 -> "MOVIE"
            1 -> "TV"
            else -> "TIDAK ADA"
        }
    }
}