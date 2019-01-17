package com.murgupluoglu.test

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.hasErrorText
import org.hamcrest.Matchers

open class BaseTestRobot {

    fun fillEditText(resId: Int, text: String): ViewInteraction =
        Espresso.onView(ViewMatchers.withId(resId)).perform(ViewActions.replaceText(text), ViewActions.closeSoftKeyboard())

    fun clickButton(resId: Int): ViewInteraction = Espresso.onView((ViewMatchers.withId(resId))).perform(ViewActions.click())

    fun getView(resId: Int): ViewInteraction = Espresso.onView(ViewMatchers.withId(resId))

    fun matchText(viewInteraction: ViewInteraction, text: String): ViewInteraction = viewInteraction
        .check(ViewAssertions.matches(ViewMatchers.withText(text)))

    fun matchText(resId: Int, text: String): ViewInteraction = matchText(getView(resId), text)

    fun matchEditTextError(resId: Int, text: String): ViewInteraction = getView(resId).check(matches(hasErrorText(text)))

    fun clickListItem(listRes: Int, position: Int) {
        Espresso.onData(Matchers.anything())
            .inAdapterView(Matchers.allOf(ViewMatchers.withId(listRes)))
            .atPosition(position).perform(ViewActions.click())
    }

    fun sleep() = apply {
        Thread.sleep(500)
    }
}