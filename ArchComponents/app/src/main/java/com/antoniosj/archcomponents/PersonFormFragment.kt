package com.antoniosj.archcomponents

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_person_form.*

class PersonFormFragment: DialogFragment() {

    lateinit var person : Person
    lateinit var viewModel : PersonFormViewModel

    companion object {
        const val EXTRA_PERSON = "person"

        fun newInstance(person: Person): PersonFormFragment {
            val args = Bundle()
            args.putSerializable(EXTRA_PERSON, person)

            val f = PersonFormFragment()
            f.arguments = args
            return f
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        viewModel = ViewModelProviders.of(this).get(PersonFormViewModel::class.java)
        person = arguments?.getSerializable(EXTRA_PERSON) as? Person ?: Person()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_person_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        et_first_name.setText(person.firstName)
        et_last_name.setText(person.lastName)
        et_age.setText(if (person.age != 0 || person.id != 0L) person.age.toString() else "")

        bt_edit.visibility = if (person.id == 0L) View.GONE else View.VISIBLE
        bt_cancel.setOnClickListener { dismiss() }
        bt_save.setOnClickListener { savePerson() }
        bt_edit.setOnClickListener { removePerson() }
    }

    private fun removePerson() {
        viewModel.deletePerson(person)
        dismiss()
    }

    private fun savePerson() {
        person.firstName = et_first_name.text.toString()
        person.lastName = et_last_name.text.toString()
        person.age = et_age.text.toString().toInt()

        viewModel.savePerson(person)
        dismiss()
    }
}
