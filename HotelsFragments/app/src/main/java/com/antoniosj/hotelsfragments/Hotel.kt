package com.antoniosj.hotelsfragments

import java.io.Serializable


data class Hotel(var name: String, var address: String, var star: Float) : Serializable {

    override fun toString(): String {
        return name
    }
}

