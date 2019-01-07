package com.antoniosj.archcomponents

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ListPeopleViewModel(app: Application): AndroidViewModel(app) {

    var livePerson: LiveData<List<Person>>? = null
    var db: IPersonDao? = null

    private fun getDao(): IPersonDao? {
        if (db == null) {
            db = AppDataBase.getDatabase(getApplication())?.personDao()
        }
        return db
    }

    fun getPerson(): LiveData<List<Person>> {
        if (livePerson == null) {
            livePerson = getDao()?.listAll()
        }
        return livePerson as LiveData<List<Person>>
    }
}