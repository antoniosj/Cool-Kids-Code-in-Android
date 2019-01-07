package com.antoniosj.archcomponents

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE

@Dao
interface IPersonDao {

    @Insert(onConflict = IGNORE)
    fun insertPerson(person: Person)

    @Update
    fun updatePerson(person: Person)

    @Delete
    fun deletePerson(vararg person: Person)

    @Query("SELECT * FROM Person ORDER by firstName")
    fun listAll(): LiveData<List<Person>>

}