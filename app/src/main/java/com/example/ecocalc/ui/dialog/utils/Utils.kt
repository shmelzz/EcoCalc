package com.example.ecocalc.ui.dialog.utils

import android.widget.TextView

fun getActivityDate(dateText: TextView): String {
    var date: String = " "

    date = when (dateText.text.toString()) {
        "date" -> "not settled"
        else -> dateText.text.toString()
    }
    return date
}