package com.antoniosj.archcomponents

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


//colocar koin ou dagger
@Database(entities = arrayOf(Person::class), version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun personDao(): IPersonDao

    companion object {

        private const val DB_NAME = "dbPerson"
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase? {

            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    DB_NAME)
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}