package com.example.todoey.ui.listTasks

import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.LifecycleRegistryOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoey.R
import com.example.todoey.contractors.TaskContract
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.android.ext.android.inject

class ListTaskActivity : AppCompatActivity(), TaskContract.View, LifecycleRegistryOwner {

    val presenter: TaskContract.Presenter by inject()
    lateinit var recyclerView: RecyclerView
    var lifecycleRegistry = LifecycleRegistry(this)

    override fun getLifecycle(): LifecycleRegistry = lifecycleRegistry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        val fbAddTask: FloatingActionButton = findViewById(R.id.fb_add_task)
        fbAddTask.setOnClickListener {
            buildAddTaskDialog()
        }
    }

    override fun initView() {
        recyclerView = findViewById(R.id.rv_tasks)
        recyclerView.layoutManager = LinearLayoutManager(this)

        presenter.getTasks().observe(this, Observer{
            recyclerView.adapter = TaskAdapter(it)
        })
    }

    private fun buildAddTaskDialog() {
        val addTaskDialog = AddTaskDialogFragment()
        addTaskDialog.onPositiveOnClickListener = DialogInterface.OnClickListener { _, which ->
            val text = addTaskDialog.dialog.findViewById<EditText>(R.id.et_task).text.toString()
            presenter.addTaskCalled(text)
        }
        addTaskDialog.show(supportFragmentManager, "")

    }
}
