package com.example.ecocalc.ui.ui_elements.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.example.ecocalc.R
import com.example.ecocalc.data.user.UserDatabase
import com.example.ecocalc.data.user.currentUser
import com.example.ecocalc.ui.state_holders.dialog.AvatarDialogViewModel
import kotlinx.coroutines.launch

class AvatarDialog(private val viewModel: AvatarDialogViewModel) : DialogFragment() {

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

            avatar1.setOnClickListener(View.OnClickListener {
                val avatar: ImageView = requireActivity().findViewById(R.id.userAvatar)
                avatar.setImageResource(R.drawable._avatar_1)
                viewModel.setupPhoto(1)
                dialog?.cancel()
            })

            avatar2.setOnClickListener(View.OnClickListener {
                val avatar: ImageView = requireActivity().findViewById(R.id.userAvatar)
                avatar.setImageResource(R.drawable._avatar_2)
                viewModel.setupPhoto(2)
                dialog?.cancel()
            })

            avatar3.setOnClickListener(View.OnClickListener {
                val avatar: ImageView = requireActivity().findViewById(R.id.userAvatar)
                avatar.setImageResource(R.drawable._avatar_3)
                viewModel.setupPhoto(3)
                dialog?.cancel()
            })

            avatar4.setOnClickListener(View.OnClickListener {
                val avatar: ImageView = requireActivity().findViewById(R.id.userAvatar)
                avatar.setImageResource(R.drawable._avatar_4)
                viewModel.setupPhoto(4)
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