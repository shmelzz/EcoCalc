package com.example.ecocalc.ui.ui_elements.activity_add.transport

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.format.DateUtils
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.ecocalc.R
import com.example.ecocalc.data.enums.TransportType
import com.example.ecocalc.data.user.currentUser
import com.example.ecocalc.data.user_activity.TransportActivity
import com.example.ecocalc.ui.state_holders.activity_add.TransportDialogViewModel
import com.example.ecocalc.ui.ui_elements.dialog.utils.getActivityDate
import java.util.*


class TransportDialog(private val transportDialogViewModel: TransportDialogViewModel) :
    DialogFragment() {

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
        val currentId = UUID.randomUUID()
        val km: Double = kmTextView.text.toString().toDouble()
        val activity: TransportActivity

        when (resources.getResourceEntryName(transportTypeId)) {
            "radio_car" -> {
                activity = TransportActivity(
                    currentId,
                    currentUser.email,
                    getActivityDate(dateText),
                    TransportType.CAR,
                    km,
                    0.19 * km,
                    false
                )
                transportDialogViewModel.addTransportActivity(activity, 0.19)
            }
            "radio_train" -> {
                activity = TransportActivity(
                    currentId,
                    currentUser.email,
                    getActivityDate(dateText),
                    TransportType.TRAIN, km,
                    0.41 * km,
                    false
                )
                transportDialogViewModel.addTransportActivity(activity, 0.41)
            }
            "radio_airplane" -> {
                activity = TransportActivity(
                    currentId, currentUser.email,
                    getActivityDate(dateText),
                    TransportType.AIRPLANE,
                    km,
                    0.15 * km,
                    false
                )
                transportDialogViewModel.addTransportActivity(activity, 0.15)
            }
            "radio_no_fuel" -> {
                activity = TransportActivity(
                    currentId,
                    currentUser.email,
                    getActivityDate(dateText),
                    TransportType.ECO_MOVE,
                    km,
                    0.0,
                    false
                )
                transportDialogViewModel.addTransportActivity(activity, 0.0)
            }
        }
    }
}
