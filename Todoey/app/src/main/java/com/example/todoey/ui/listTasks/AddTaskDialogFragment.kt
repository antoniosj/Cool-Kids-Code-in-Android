package com.example.todoey.ui.listTasks

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import com.example.todoey.R

class AddTaskDialogFragment: DialogFragment() {

    var onPositiveOnClickListener: DialogInterface.OnClickListener ?= null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(activity)
            .setView(R.layout.task_dialog)
            .setTitle("Define localTaskRepository title for your task")
            .setPositiveButton("Ok", onPositiveOnClickListener)
            .setNeutralButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }.create()
    }
}