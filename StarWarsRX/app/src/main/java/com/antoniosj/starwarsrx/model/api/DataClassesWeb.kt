package com.antoniosj.starwarsrx.model.api

import com.google.gson.annotations.SerializedName

data class FilmResult(val results: List<Film>)

//serialized name para representar o valor correto no GSON.
data class Film(
                val title: String,
                @SerializedName("episode_id") val episodeId: Int,
                @SerializedName("characters") val personUrls: List<String>) //lista de strins vai virar lista de pessoas

data class Person(val name: String, val gender: String) {

    override fun toString(): String {
        return "$name - $gender"
    }
}