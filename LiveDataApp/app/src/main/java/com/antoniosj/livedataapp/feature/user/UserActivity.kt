package com.antoniosj.livedataapp.feature.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.antoniosj.livedataapp.R
import com.antoniosj.livedataapp.entity.User
import kotlinx.android.synthetic.main.activity_user.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.lang.StringBuilder

class UserActivity : AppCompatActivity() {

    val viewModel by viewModel<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        button.setOnClickListener{
            val user = User("well", 70)
            val user2 = User("Baiano", 43)

            viewModel.addUser(user)
            viewModel.addUser(user2)
        }
        val items = StringBuilder()
        viewModel.getAllUsers().observe(this, Observer {
            it.forEach { user ->
                items.append("${user.name} - ${user.age}").append("\n")
                txt.text = items.toString()
            }
        })
    }
}
