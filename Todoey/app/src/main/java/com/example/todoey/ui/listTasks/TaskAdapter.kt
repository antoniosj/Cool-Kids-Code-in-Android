package com.example.todoey.ui.listTasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoey.R
import com.example.todoey.domain.entities.Task

class TaskAdapter(var tasks: List<Task>): RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.hTextViewTitle.text = tasks[position].title
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var hTextViewTitle: TextView = itemView.findViewById(R.id.tv_task)
    }
}