package com.example.ecocalc.ui.dialog

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.format.DateUtils
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextClock
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.ecocalc.R
import com.example.ecocalc.data.enums.TransportType
import com.example.ecocalc.data.user.UserDatabase
import com.example.ecocalc.data.user.currentUser
import com.example.ecocalc.data.user_activity.TransportActivity
import com.example.ecocalc.ui.dialog.utils.getActivityDate
import java.util.*


class TransportDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            val inflater = requireActivity().layoutInflater

            val transportView: View = inflater.inflate(R.layout.transport_dialog_layout, null)
            val dateButton: Button = transportView.findViewById(R.id.choose_date)
            val dateText: TextView = transportView.findViewById(R.id.dateTextView)
            val radioGroup: RadioGroup =
                transportView.findViewById(R.id.transport_radio_group)
            val kmText: TextView = transportView.findViewById(R.id.kilometresDrivenTextView)

            val dateAndTime: Calendar = Calendar.getInstance()

            fun setInitialDateTime() {
                dateText.text = DateUtils.formatDateTime(
                    requireContext(),
                    dateAndTime.timeInMillis,
                    DateUtils.FORMAT_SHOW_DATE or DateUtils.FORMAT_SHOW_YEAR
                )
            }

            val d =
                OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    dateAndTime.set(Calendar.YEAR, year)
                    dateAndTime.set(Calendar.MONTH, monthOfYear)
                    dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    setInitialDateTime()
                }

            dateButton.setOnClickListener(View.OnClickListener { view ->
                DatePickerDialog(
                    it, d,
                    dateAndTime.get(Calendar.YEAR),
                    dateAndTime.get(Calendar.MONTH),
                    dateAndTime.get(Calendar.DAY_OF_MONTH)
                ).show()
            })

            builder.setView(transportView)
                .setPositiveButton("Ok",
                    DialogInterface.OnClickListener { dialog, id ->
                        addTransportActivity(radioGroup, dateText, kmText)
                        val userDao =
                            UserDatabase.getDataBase(requireActivity().application).userDao()
                        userDao.updateUsers(currentUser)
                        getDialog()?.cancel()
                    })
                .setNegativeButton("Cancel",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }


    private fun addTransportActivity(
        radioGroup: RadioGroup,
        dateText: TextView,
        kmTextView: TextView
    ) {
        val transportTypeId = radioGroup.checkedRadioButtonId
        val currentId: Int = currentUser.transportActivities.size

        val km: Double = kmTextView.text.toString().toDouble()

        when (resources.getResourceEntryName(transportTypeId)) {
            "radio_car" -> {
                currentUser.transportActivities.add(
                    TransportActivity(
                        currentId, getActivityDate(dateText), TransportType.CAR, km,
                        0.19 * km, false
                    )
                )
                currentUser.transportPrint += 0.19 * km
                currentUser.carbonPrint += 0.19 * km
            }
            "radio_train" -> {
                currentUser.transportActivities.add(
                    TransportActivity(
                        currentId, getActivityDate(dateText), TransportType.TRAIN, km,
                        0.41 * km, false
                    )
                )
                currentUser.transportPrint += 0.41 * km
                currentUser.carbonPrint += 0.41 * km
            }
            "radio_airplane" -> {
                currentUser.transportActivities.add(
                    TransportActivity(
                        currentId, getActivityDate(dateText), TransportType.AIRPLANE, km,
                        0.15 * km, false
                    )
                )
                currentUser.transportPrint += 0.15 * km
                currentUser.carbonPrint += 0.15 * km
            }
            "radio_no_fuel" -> {
                currentUser.transportActivities.add(
                    TransportActivity(
                        currentId, getActivityDate(dateText), TransportType.ECO_MOVE, km,
                        0.0, false
                    )
                )
            }
        }
    }
}
