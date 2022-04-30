package com.example.ecocalc.ui.account

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ecocalc.R
import com.example.ecocalc.data.user.currentUser
import com.example.ecocalc.databinding.FragmentAccountBinding
import com.example.ecocalc.ui.dialog.AboutDialog
import com.example.ecocalc.ui.dialog.SettingsDialog
import com.example.ecocalc.ui.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AccountFragment : Fragment() {

    private lateinit var accountViewModel: AccountViewModel
    private var _binding: FragmentAccountBinding? = null

    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        accountViewModel =
            ViewModelProvider(this).get(AccountViewModel::class.java)
        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.aboutButton.apply {
            setOnClickListener(View.OnClickListener { view ->
                val aboutDialog = AboutDialog()
                activity?.supportFragmentManager?.let { aboutDialog.show(it, "about") }
            })
        }

        auth = Firebase.auth
        binding.exitButton.apply {
            setOnClickListener(View.OnClickListener { view ->
                auth.signOut()
                val intent = Intent(activity, LoginActivity::class.java)
                startActivity(intent)
            })
        }

        binding.settingsButton.apply {
            setOnClickListener(View.OnClickListener { view ->
                val dialog = SettingsDialog()
                activity?.supportFragmentManager?.let { dialog.show(it, "settings") }
            })
        }

        binding.userName.text = currentUser.email

        return root
    }

    // TODO возможно тут нет нужен onStart
    override fun onStart() {
        super.onStart()
        when (currentUser.photo) {
            1 -> binding.userAvatar.setImageResource(R.drawable._avatar_1)
            2 -> binding.userAvatar.setImageResource(R.drawable._avatar_2)
            3 -> binding.userAvatar.setImageResource(R.drawable._avatar_3)
            else -> binding.userAvatar.setImageResource(R.drawable._avatar_4)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}