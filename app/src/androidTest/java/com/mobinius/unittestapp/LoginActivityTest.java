package com.mobinius.unittestapp;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void loginActivityTest() {
        ViewInteraction editText = onView(
                allOf(withId(R.id.username_edit_text),
                        withParent(allOf(withId(R.id.admin_login_activity_main_linear_layout),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        editText.perform(replaceText("prasabba"), closeSoftKeyboard());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.password_edit_text),
                        withParent(allOf(withId(R.id.admin_login_activity_main_linear_layout),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        editText2.perform(replaceText("fsdfsdf"), closeSoftKeyboard());

        ViewInteraction button = onView(
                allOf(withId(R.id.login_button), withText("LOG IN"),
                        withParent(allOf(withId(R.id.admin_login_activity_main_linear_layout),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        button.perform(click());

        ViewInteraction button2 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        withParent(allOf(withClassName(is("android.widget.LinearLayout")),
                                withParent(withClassName(is("android.widget.LinearLayout"))))),
                        isDisplayed()));
        button2.perform(click());

    }

}
