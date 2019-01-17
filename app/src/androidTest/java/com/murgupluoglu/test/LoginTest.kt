package com.murgupluoglu.test

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginTest {

    @get:Rule
    val mActivityTestRule: ActivityTestRule<LoginActivity> = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun loginMissingEmailPassword() {
        login {
            clickLogin()
            matchEditTextError(string(R.string.missing_email))
        }
    }

    private fun string(res: Int): String = mActivityTestRule.activity.getString(res)
}