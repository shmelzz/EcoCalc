package com.example.ecocalc.ui.ui_elements.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class AboutDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setPositiveButton("Ok",
                DialogInterface.OnClickListener { dialog, id ->
                    getDialog()?.cancel()
                })
                .setTitle("About EcoCalc")
                .setMessage("This is EcoCalc! It is about ecology and reducing waste.")
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}