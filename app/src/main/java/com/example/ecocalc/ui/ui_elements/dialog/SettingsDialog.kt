package com.example.ecocalc.ui.ui_elements.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.ecocalc.R
import com.example.ecocalc.data.user.UserDao
import com.example.ecocalc.data.user.UserDatabase
import com.example.ecocalc.ui.state_holders.dialog.AuthDialogViewModel
import com.example.ecocalc.ui.state_holders.dialog.AvatarDialogViewModel

class SettingsDialog : DialogFragment() {

    private lateinit var userDao: UserDao

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            userDao = UserDatabase.getDataBase(requireActivity().application).userDao()

            val inflater = requireActivity().layoutInflater

            val settingsView: View = inflater.inflate(R.layout.settings_dialog_layout, null)
            val emailButton: Button = settingsView.findViewById(R.id.change_email_button)
            val passwordButton: Button = settingsView.findViewById(R.id.change_password_button)
            val avatarButton: Button = settingsView.findViewById(R.id.change_avatar_button)

            emailButton.setOnClickListener(View.OnClickListener { view ->
                val dialog = EmailDialog(AuthDialogViewModel())
                getDialog()?.cancel()
                activity?.supportFragmentManager?.let { dialog.show(it, "email change") }
            })

            passwordButton.setOnClickListener(View.OnClickListener { view ->
                val dialog = PasswordDialog(AuthDialogViewModel())
                getDialog()?.cancel()
                activity?.supportFragmentManager?.let { dialog.show(it, "password change") }
            })

            avatarButton.setOnClickListener(View.OnClickListener { view ->
                val dialog = AvatarDialog(AvatarDialogViewModel(userDao))
                getDialog()?.cancel()
                activity?.supportFragmentManager?.let { dialog.show(it, "avatar change") }
            })

            builder.setView(settingsView)
                .setPositiveButton("Cancel",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}