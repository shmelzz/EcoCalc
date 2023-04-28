package com.example.ecocalc.ui.ui_elements.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModel
import com.example.ecocalc.R
import com.example.ecocalc.ui.state_holders.dialog.AuthDialogViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class PasswordDialog(private val viewModel: AuthDialogViewModel) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            val inflater = requireActivity().layoutInflater

            val passwordChangeView: View =
                inflater.inflate(R.layout.edit_password_dialog_layout, null)
            val passwordEditText: EditText =
                passwordChangeView.findViewById(R.id.editTextTextPassword)

            builder.setView(passwordChangeView)
                .setPositiveButton("Ok",
                    DialogInterface.OnClickListener { dialog, id ->
                        if (TextUtils.isEmpty(passwordEditText.text.toString())) {
                            passwordEditText.error = "Required"
                        } else if (passwordEditText.text.toString().length < 5) {
                            passwordEditText.error = "more than 5 letters"
                        } else {
                            viewModel.changePassword(passwordEditText.text.toString())
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