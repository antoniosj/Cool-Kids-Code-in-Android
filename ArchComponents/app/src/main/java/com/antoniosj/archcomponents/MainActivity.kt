package com.antoniosj.archcomponents

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.LifecycleRegistryOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LifecycleRegistryOwner {

    var lifecycleRegistry = LifecycleRegistry(this)

    override fun getLifecycle(): LifecycleRegistry = lifecycleRegistry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener {
            PersonFormFragment().show(supportFragmentManager, "form")
        }

        val model = ViewModelProviders.of(this).get(ListPeopleViewModel::class.java)
        model.getPerson().observe(this, Observer { person -> listview.adapter = ArrayAdapter<Person>(this@MainActivity, android.R.layout.simple_list_item_1, person)
        listview.setOnItemClickListener { _, _, position, _ ->
            val p = person?.get(position)
            if (p != null) {
                PersonFormFragment.newInstance(p).show(supportFragmentManager, "form")
            }
        }
        })
    }

    override fun onDestroy() {
        AppDataBase.destroyInstance()
        super.onDestroy()
    }
}
