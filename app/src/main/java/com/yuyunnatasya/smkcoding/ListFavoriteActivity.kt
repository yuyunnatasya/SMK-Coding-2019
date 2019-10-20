package com.yuyunnatasya.smkcoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yuyunnatasya.smkcoding.database.DatabaseContract
import com.yuyunnatasya.smkcoding.database.database
import com.yuyunnatasya.smkcoding.model.ResultsItem
import kotlinx.coroutines.selects.select
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class ListFavoriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_favorite)

        selectFavoriteListFromSqlite()
    }

    private fun selectFavoriteListFromSqlite(){
        database.use{
            val selectData = select(ResultsItem.TABLE_FAVORITE)
            val list: MutableList<DatabaseContract> =
                selectData.parseList(classParser<DatabaseContract>()) as MutableList
            var arrayListMovie =
                list as ArrayList<DatabaseContract>
            Log.d("LISTFAVORITE", arrayListMovie.toString())
        }
    }
}
