package com.example.ecocalc.ui.ui_elements.added_activities

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecocalc.R
import com.example.ecocalc.data.user.currentUser
import com.example.ecocalc.ui.state_holders.activity_add.MealDialogViewModel
import com.example.ecocalc.ui.state_holders.added_activities.AddedActivitiesDialogViewModel

class AddedActivitiesDialog(
    activityType: String,
    private val viewModel: AddedActivitiesDialogViewModel
) : DialogFragment() {

    private val listActivityType: String = activityType

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            val inflater = requireActivity().layoutInflater

            val activitiesView: View = inflater.inflate(R.layout.fragment_articles_list, null)
            val list: RecyclerView = activitiesView.findViewById(R.id.articles_list)

            when (listActivityType) {
                "MEAL" -> {
                    list.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = MealCardAdapter(viewModel.getAddedMealActivities())
                    }
                }
                "TRANSPORT" -> {
                    list.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = TransportCardAdapter(viewModel.getAddedTransportActivities())
                    }
                }
                else -> {
                    list.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = PlasticCardAdapter(viewModel.getAddedPlasticActivities())
                    }
                }
            }

            builder.setView(activitiesView)
                .setPositiveButton("OK",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}