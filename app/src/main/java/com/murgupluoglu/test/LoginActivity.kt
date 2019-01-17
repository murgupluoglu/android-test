package com.murgupluoglu.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton.setOnClickListener {
            if(validate()){
                infoTextView.text = "Success"
            }
        }
    }

    fun validate() : Boolean {
        val email = emailEditText.text
        val password = passwordEditText.text

        if(email.isEmpty()){
            emailEditText.error = getString(R.string.missing_email)
            return false
        }

        if(password.isEmpty()){
            passwordEditText.error = getString(R.string.missing_password)
            return false
        }

        return true
    }
}
