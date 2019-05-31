package com.antoniosj.livedataapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.antoniosj.livedataapp.entity.User
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class UserFireStoreDataSource(private val collection: CollectionReference): IUserRepository {

    override fun addUser(user: User) {
        collection.add(user)
    }

    override fun getAllUsers(): LiveData<List<User>> {

        val result = MutableLiveData<List<User>>()

       collection.addSnapshotListener { querySnapshot, firebaseFirestoreException ->
            if (firebaseFirestoreException != null) return@addSnapshotListener

            if (querySnapshot != null) {
                result.value = querySnapshot.toObjects(User::class.java)
            } else {
                result.value = emptyList()
            }
        }
        return result
    }


}