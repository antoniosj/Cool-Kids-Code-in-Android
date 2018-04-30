package com.antoniosj.starwarsrx.model.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsApi {
    @GET("films")
    fun listMovies(): Observable<FilmResult>

    @GET("people/{personId}") fun loadPerson(@Path("personId") personId: String) : Observable<Person>
}