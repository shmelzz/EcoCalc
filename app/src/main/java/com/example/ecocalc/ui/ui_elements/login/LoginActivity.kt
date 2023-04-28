package com.example.ecocalc.ui.ui_elements.login

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ecocalc.databinding.ActivityLoginBinding
import com.example.ecocalc.ui.ui_elements.MainActivity
import com.example.ecocalc.ui.ui_elements.dialog.AboutDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var auth: FirebaseAuth

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser

        if (currentUser != null) {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            intent.putExtra("username", currentUser.email)
            intent.putExtra("isNewUser", false)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val signInButton = binding.signInButton
        val createAccountButton = binding.createAccountButton
        val aboutButton = binding.aboutApp

        signInButton.setOnClickListener(View.OnClickListener { view ->
            val email = binding.username.text.toString()
            val enteredPassword = binding.password.text.toString()
            signIn(email, enteredPassword)
        })

        createAccountButton!!.setOnClickListener(View.OnClickListener { view ->
            val email = binding.username.text.toString()
            val password = binding.password.text.toString()
            createAccount(email, password)
        })

        aboutButton?.setOnClickListener(View.OnClickListener { view ->
            val aboutDialog = AboutDialog()
            supportFragmentManager.let { aboutDialog.show(it, "about") }
        })

        auth = Firebase.auth
    }

    private fun checkForm(): Boolean {
        var valid = true
        val email = binding.username.text.toString()
        if (TextUtils.isEmpty(email)) {
            binding.username.error = "Required."
            valid = false
        } else {
            binding.username.error = null
        }

        val password = binding.password.text.toString()
        if (TextUtils.isEmpty(password)) {
            binding.password.error = "Required."
            valid = false
        } else {
            binding.password.error = null
        }
        return valid
    }

    private fun createAccount(email: String, password: String) {
        if (!checkForm()) {
            return
        }

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    intent.putExtra("username", email)
                    intent.putExtra("isNewUser", true)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    private fun signIn(email: String, password: String) {
        Log.d(TAG, "signIn:$email")
        if (!checkForm()) {
            return
        }

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "signInWithEmail:success")
                    // val user = auth.currentUser
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    intent.putExtra("username", email)
                    intent.putExtra("isNewUser", false)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}
