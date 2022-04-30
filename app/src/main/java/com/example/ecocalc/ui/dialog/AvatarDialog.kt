package com.example.ecocalc.ui.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.ecocalc.R
import com.example.ecocalc.data.user.UserDatabase
import com.example.ecocalc.data.user.currentUser

class AvatarDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            val inflater = requireActivity().layoutInflater

            val avatarChangeView: View =
                inflater.inflate(R.layout.avatar_change_dialog_layout, null)
            val avatar1: ImageButton = avatarChangeView.findViewById(R.id.avatar_1)
            val avatar2: ImageButton = avatarChangeView.findViewById(R.id.avatar_2)
            val avatar3: ImageButton = avatarChangeView.findViewById(R.id.avatar_3)
            val avatar4: ImageButton = avatarChangeView.findViewById(R.id.avatar_4)

            avatar1.setOnClickListener(View.OnClickListener { view ->
                currentUser.photo = 1
                val avatar: ImageView = requireActivity().findViewById(R.id.userAvatar)
                avatar.setImageResource(R.drawable._avatar_1)

                val userDao = UserDatabase.getDataBase(requireActivity().application).userDao()
                userDao.updateUsers(currentUser)

                dialog?.cancel()
            })

            avatar2.setOnClickListener(View.OnClickListener { view ->
                currentUser.photo = 2
                val avatar: ImageView = requireActivity().findViewById(R.id.userAvatar)
                avatar.setImageResource(R.drawable._avatar_2)

                val userDao = UserDatabase.getDataBase(requireActivity().application).userDao()
                userDao.updateUsers(currentUser)

                dialog?.cancel()
            })

            avatar3.setOnClickListener(View.OnClickListener { view ->
                currentUser.photo = 3
                val avatar: ImageView = requireActivity().findViewById(R.id.userAvatar)
                avatar.setImageResource(R.drawable._avatar_3)

                val userDao = UserDatabase.getDataBase(requireActivity().application).userDao()
                userDao.updateUsers(currentUser)

                dialog?.cancel()
            })

            avatar4.setOnClickListener(View.OnClickListener { view ->
                currentUser.photo = 4
                val avatar: ImageView = requireActivity().findViewById(R.id.userAvatar)
                avatar.setImageResource(R.drawable._avatar_4)

                val userDao = UserDatabase.getDataBase(requireActivity().application).userDao()
                userDao.updateUsers(currentUser)

                dialog?.cancel()
            })

            builder.setView(avatarChangeView)
                .setNegativeButton("Cancel",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}