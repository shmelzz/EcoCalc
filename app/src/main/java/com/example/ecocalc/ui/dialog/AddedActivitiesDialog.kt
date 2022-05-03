package com.example.ecocalc.ui.dialog

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
import com.example.ecocalc.ui.added_activities.MealCardAdapter
import com.example.ecocalc.ui.added_activities.PlasticCardAdapter
import com.example.ecocalc.ui.added_activities.TransportCardAdapter

class AddedActivitiesDialog(activityType: String) : DialogFragment() {

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
                        adapter = MealCardAdapter(currentUser.mealActivities)
                    }
                }
                "TRANSPORT" -> {
                    list.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = TransportCardAdapter(currentUser.transportActivities)
                    }
                }
                else -> {
                    list.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = PlasticCardAdapter(currentUser.plasticActivities)
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