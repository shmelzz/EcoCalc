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
import com.example.ecocalc.data.enums.MealType
import com.example.ecocalc.data.user.UserDatabase
import com.example.ecocalc.data.user.currentUser
import com.example.ecocalc.data.user_activity.MealActivity
import com.example.ecocalc.ui.dialog.utils.getActivityDate
import java.util.*
import kotlin.math.roundToInt

class MealDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            val inflater = requireActivity().layoutInflater

            val mealView: View = inflater.inflate(R.layout.meal_dialog_layput, null)
            val dateButton: Button = mealView.findViewById(R.id.choose_date)
            val dateText: TextView = mealView.findViewById(R.id.dateTextView)
            val radioGroup: RadioGroup =
                mealView.findViewById(R.id.meal_group)

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

            builder.setView(mealView)
                .setPositiveButton("Ok",
                    DialogInterface.OnClickListener { dialog, id ->
                        addMealActivity(radioGroup, dateText)
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


    private fun addMealActivity(
        radioGroup: RadioGroup,
        dateText: TextView
    ) {
        val mealTypeId = radioGroup.checkedRadioButtonId
        val currentId: Int = currentUser.mealActivities.size

        when (resources.getResourceEntryName(mealTypeId)) {
            "radio_standard" -> {
                currentUser.mealActivities.add(
                    MealActivity(
                        currentId, getActivityDate(dateText), MealType.STANDARD,
                        6.85
                    )
                )
                currentUser.mealPrint += 6.85
                currentUser.carbonPrint += 6.85
            }
            "radio_vegetarian" -> {
                currentUser.mealActivities.add(
                    MealActivity(
                        currentId,
                        getActivityDate(dateText),
                        MealType.VEGETARIAN,
                        4.66
                    )
                )
                currentUser.mealPrint += 4.66
                currentUser.carbonPrint += 4.66
            }
            "radio_vegan" -> {
                currentUser.mealActivities.add(
                    MealActivity(
                        currentId,
                        getActivityDate(dateText),
                        MealType.VEGAN,
                        4.11
                    )
                )
                currentUser.mealPrint += 4.11
                currentUser.carbonPrint += 4.11
            }
            "radio_meat" -> {
                currentUser.mealActivities.add(
                    MealActivity(
                        currentId,
                        getActivityDate(dateText),
                        MealType.MEAT,
                        9.04
                    )
                )
                currentUser.mealPrint += 9.04
                currentUser.carbonPrint += 9.04
            }
        }
    }
}