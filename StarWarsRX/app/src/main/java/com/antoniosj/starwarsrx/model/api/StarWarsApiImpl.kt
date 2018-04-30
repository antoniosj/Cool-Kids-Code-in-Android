package com.antoniosj.starwarsrx.model.api

import android.net.Uri
import android.util.Log
import com.antoniosj.starwarsrx.model.Character
import com.antoniosj.starwarsrx.model.Movie
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class StarWarsApiImpl {

    val service: StarWarsApi
    val peopleCache = mutableMapOf<String, Person>()
    init {

        val logging = HttpLoggingInterceptor() // loggar o service do retrofit
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder() //cliente do okhttp
        httpClient.addInterceptor(logging)

        val gson = GsonBuilder().setLenient().create()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://swapi.co/api/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build()

        service = retrofit.create<StarWarsApi>(StarWarsApi::class.java)
    }

    fun loadMovies(): Observable<Movie> {
        return service.listMovies()
                .flatMap { filmResult -> Observable.fromIterable(filmResult.results) }
                .map {  film -> Movie(film.title, film.episodeId, ArrayList<Character>()) }
    }

    fun loadMoviesFull(): Observable<Movie> {
        return service.listMovies()
                .flatMap { filmResult -> Observable.fromIterable(filmResult.results) }
                .flatMap {  film ->
                    val movieObj = Movie(film.title, film.episodeId, ArrayList<Character>())
                    Observable.zip(
                            Observable.just(movieObj),
                            Observable.fromIterable(film.personUrls)
                                    .flatMap
                                    { personUrl ->
                                        Observable.concat(getCache(personUrl),service.loadPerson(Uri.parse(personUrl).lastPathSegment) .doOnNext { person ->
                                            Log.d("Antoniosj", "DOWNLOAD -------> $personUrl")
                                            peopleCache.put(personUrl, person!!)
                                        })
                                                .take(1).map { person ->
                                                    Character(person.name, person.gender)
                                                }
                                    }
                                    .toList().toObservable(),
                                BiFunction<Movie, List<Character>, Movie> {
                                    movie, characters -> movie.characters.addAll(characters)
                                    movie
                                })
                }
    }

    private fun getCache(personUrl: String): Observable<Person?> {
        return Observable.fromIterable(peopleCache.keys)
                .filter { key ->
                    key == personUrl
                }
                .map { key ->
                    Log.d("Antoniosj", "CACHE -------> $key")
                    peopleCache[key]
                }
    }
}