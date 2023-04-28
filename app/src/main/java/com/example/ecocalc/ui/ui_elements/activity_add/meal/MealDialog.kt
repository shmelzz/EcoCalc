package com.example.ecocalc.ui.ui_elements.activity_add.meal

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
import com.example.ecocalc.data.user.currentUser
import com.example.ecocalc.data.user_activity.MealActivity
import com.example.ecocalc.ui.state_holders.activity_add.MealDialogViewModel
import com.example.ecocalc.ui.ui_elements.dialog.utils.getActivityDate
import java.util.*

class MealDialog(private val mealDialogViewModel: MealDialogViewModel) : DialogFragment() {

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
        val currentId = UUID.randomUUID()
        val activity: MealActivity

        when (resources.getResourceEntryName(mealTypeId)) {
            "radio_standard" -> {
                activity = MealActivity(
                    currentId, currentUser.email, getActivityDate(dateText), MealType.STANDARD,
                    6.85
                )
                mealDialogViewModel.addMealActivity(activity)
            }
            "radio_vegetarian" -> {
                activity = MealActivity(
                    currentId,
                    currentUser.email,
                    getActivityDate(dateText),
                    MealType.VEGETARIAN,
                    4.66
                )
                mealDialogViewModel.addMealActivity(activity)
            }
            "radio_vegan" -> {
                activity = MealActivity(
                    currentId,
                    currentUser.email,
                    getActivityDate(dateText),
                    MealType.VEGAN,
                    4.11
                )
                mealDialogViewModel.addMealActivity(activity)
            }
            "radio_meat" -> {
                activity = MealActivity(
                    currentId,
                    currentUser.email,
                    getActivityDate(dateText),
                    MealType.MEAT,
                    9.04
                )
                mealDialogViewModel.addMealActivity(activity)
            }
        }
    }
}