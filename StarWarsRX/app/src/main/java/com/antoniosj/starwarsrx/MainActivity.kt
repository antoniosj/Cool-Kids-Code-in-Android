package com.antoniosj.starwarsrx

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.antoniosj.starwarsrx.model.api.StarWarsApiImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

    lateinit var listView : ListView
    lateinit var movieAdapter : ArrayAdapter<String>
    var movies = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //cria um adapter simples não customizável
        listView = ListView(this)
        setContentView(listView)
        movieAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, movies)
        listView.adapter = movieAdapter

        //Rx Javinha
        val api = StarWarsApiImpl() //instance
        api.loadMoviesFull().subscribeOn(Schedulers.io()) //subscribe na thread IO
                .observeOn(AndroidSchedulers.mainThread()) //observe na main Thread
                .subscribe({
                    movie -> movies.add("${movie.title} - ${movie.episodeId} \n ${movie.characters.toString()}")  //on next
                }, {
                    e -> e.printStackTrace() // on error
                }, {
                    movieAdapter.notifyDataSetChanged() // on complete
                })

    }
}
