package com.murgupluoglu.test

fun login(func: LoginRobot.() -> Unit) = LoginRobot().apply { func() }

class LoginRobot : BaseTestRobot() {

    fun setEmail(email: String) = fillEditText(R.id.emailEditText, email)

    fun setPassword(pass: String) = fillEditText(R.id.passwordEditText, pass)

    fun clickLogin() = clickButton(R.id.loginButton)

    fun matchInfoText(info: String) = matchText(getView(R.id.infoTextView), info)

    fun matchEditTextError(info: String) = matchEditTextError(R.id.emailEditText, info)

}