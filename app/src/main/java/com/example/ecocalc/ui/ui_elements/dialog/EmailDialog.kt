package com.example.ecocalc.ui.ui_elements.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.ecocalc.R
import com.example.ecocalc.ui.state_holders.dialog.AuthDialogViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class EmailDialog(private val viewModel: AuthDialogViewModel) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            val inflater = requireActivity().layoutInflater

            val emailChangeView: View = inflater.inflate(R.layout.edit_email_dialog_layout, null)
            val emailEditText: EditText =
                emailChangeView.findViewById(R.id.editTextTextEmailAddress)

            builder.setView(emailChangeView)
                .setPositiveButton("Ok",
                    DialogInterface.OnClickListener { dialog, id ->
                        if (TextUtils.isEmpty(emailEditText.text.toString())) {
                            emailEditText.error = "Required"
                        } else if ((!emailEditText.text.toString().contains("@"))
                            || (!emailEditText.text.toString().contains("."))
                        ) {
                            emailEditText.error = "Must be email"
                        } else {
                            viewModel.changeEmail(emailEditText.text.toString())
                            getDialog()?.cancel()
                        }
                    })
                .setNegativeButton("Cancel",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")

    }
}