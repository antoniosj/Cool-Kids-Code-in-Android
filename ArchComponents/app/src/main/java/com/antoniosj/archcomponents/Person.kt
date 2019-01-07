package com.antoniosj.archcomponents

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


//Entidade
@Entity
data class Person(
    @PrimaryKey(autoGenerate = true) var id: Long = 0L,
    var firstName: String = "",
    var lastName: String = "",
    var age: Int = 0) : Serializable