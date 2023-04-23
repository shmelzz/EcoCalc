package com.example.ecocalc.ui.dialog

import android.app.DatePickerDialog
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
import com.example.ecocalc.data.enums.PlasticType
import com.example.ecocalc.data.user.UserDatabase
import com.example.ecocalc.data.user.currentUser
import com.example.ecocalc.data.user_activity.PlasticActivity
import com.example.ecocalc.ui.dialog.utils.getActivityDate
import java.util.*

class PlasticDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            val inflater = requireActivity().layoutInflater

            val plasticView: View = inflater.inflate(R.layout.plastic_dialog_layout, null)
            val dateButton: Button = plasticView.findViewById(R.id.choose_date)
            val dateText: TextView = plasticView.findViewById(R.id.dateTextView)
            val radioGroup: RadioGroup = plasticView.findViewById(R.id.plastic_group)

            val dateAndTime: Calendar = Calendar.getInstance()

            fun setInitialDateTime() {
                dateText.text = DateUtils.formatDateTime(
                    requireContext(),
                    dateAndTime.timeInMillis,
                    DateUtils.FORMAT_SHOW_DATE or DateUtils.FORMAT_SHOW_YEAR
                )
            }

            val d =
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
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

            builder.setView(plasticView)
                .setPositiveButton("Ok",
                    DialogInterface.OnClickListener { dialog, id ->
                        addPlasticActivity(radioGroup, dateText)
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

    private fun addPlasticActivity(
        radioGroup: RadioGroup,
        dateText: TextView
    ) {
        val plasticTypeId = radioGroup.checkedRadioButtonId
        val currentId = UUID.randomUUID()

        val userDao =
            UserDatabase.getDataBase(requireActivity().application).userDao()

        when (resources.getResourceEntryName(plasticTypeId)) {
            "radio_standard_bag" -> {
                val activity = PlasticActivity(
                    currentId,
                    currentUser.email,
                    getActivityDate(dateText),
                    PlasticType.STANDARD,
                    6.92
                )
                currentUser.plasticActivities.add(activity)
                userDao.addPlasticActivity(activity)
                currentUser.plasticPrint += 6.92
                currentUser.carbonPrint += 6.92
            }
            "radio_strong_bag" -> {
                val activity = PlasticActivity(
                    currentId,
                    currentUser.email,
                    getActivityDate(dateText),
                    PlasticType.STRONG,
                    21.51
                )
                currentUser.plasticActivities.add(activity)
                userDao.addPlasticActivity(activity)
                currentUser.plasticPrint += 21.51
                currentUser.carbonPrint += 21.51
            }
            "radio_one_use_bag" -> {
                val activity = PlasticActivity(
                    currentId,
                    currentUser.email,
                    getActivityDate(dateText),
                    PlasticType.ONE_USE,
                    1.58
                )
                currentUser.plasticActivities.add(activity)
                userDao.addPlasticActivity(activity)
                currentUser.plasticPrint += 1.58
                currentUser.carbonPrint += 1.58
            }
            "radio_paper_bag" -> {
                val activity = PlasticActivity(
                    currentId,
                    currentUser.email,
                    getActivityDate(dateText),
                    PlasticType.PAPER,
                    5.52
                )
                currentUser.plasticActivities.add(activity)
                userDao.addPlasticActivity(activity)
                currentUser.plasticPrint += 5.52
                currentUser.carbonPrint += 5.52
            }
        }
    }
}


