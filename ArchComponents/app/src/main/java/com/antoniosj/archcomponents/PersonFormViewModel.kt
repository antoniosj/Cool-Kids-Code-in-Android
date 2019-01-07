package com.antoniosj.archcomponents

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class PersonFormViewModel(app: Application): AndroidViewModel(app) {

    private var db: IPersonDao? = null

    private fun personDao(): IPersonDao? {
        if (db == null) {
            db = AppDataBase.getDatabase(getApplication())?.personDao()
        }
        return db
    }

    fun savePerson(person: Person) {
        if (person.id == 0L) {
            personDao()?.insertPerson(person)
        } else {
            personDao()?.updatePerson(person)
        }
    }

    fun deletePerson(person: Person) {
        personDao()?.deletePerson(person)
    }
}