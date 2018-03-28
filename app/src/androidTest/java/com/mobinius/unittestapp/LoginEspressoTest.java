package com.mobinius.unittestapp;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by prajna on 8/11/16.
 */

//@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginEspressoTest {

    public static final String USERNAME_TO_BE_TYPED = "prajna@gmail.com";
    public static final String WRONG_USERNAME_TO_BE_TYPED = "abc@gmail.com";
    public static final String PASSWORD_TO_BE_TYPED = "12345678";
    public static final String INVALID_USERNAME_TO_BE_TYPED = "prajna";
    public static final String INVALID_PASSWORD_TO_BE_TYPED = "1253";
    public static final String WELCOME = "WELCOME";

    @Rule
    public ActivityTestRule<LoginActivity> mActivity = new ActivityTestRule<>(
            LoginActivity.class);

    @Test
    public void testValidUserNamePassword() {
        // Type username and password and then press the button.
        onView(withId(R.id.username_edit_text))
                .perform(typeText(WRONG_USERNAME_TO_BE_TYPED), closeSoftKeyboard());
        onView(withId(R.id.password_edit_text))
                .perform(typeText(PASSWORD_TO_BE_TYPED), closeSoftKeyboard());
        onView(withId(R.id.login_button)).perform(click());

        onView(withId(R.id.register_name)).perform(typeText(USERNAME_TO_BE_TYPED));
        onView(withId(R.id.register_password)).perform(typeText(PASSWORD_TO_BE_TYPED));
        onView(withId(R.id.register_submit)).perform(click());
        onView(withId(R.id.login_button)).perform(click());

        onView(withText("OK")).check(matches(isDisplayed()));
        onView(withText("Cancel")).check(matches(isDisplayed()));
        onView(withText("Login Successful")).check(matches(isDisplayed()));

        onView(withText("OK")).perform(click());
        onView(withId(R.id.welcome_text_view)).check(matches(withText(WELCOME)));
        onView(withId(R.id.username_value)).check(matches(withText(USERNAME_TO_BE_TYPED)));
        onView(withId(R.id.password_value)).check(matches(withText(PASSWORD_TO_BE_TYPED)));
        onView(withId(R.id.click_button)).perform(click());
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.scrollToPosition(27));

        int max = 30;
        int min = 0;
        int diff = max - min;
        Random rn = new Random();
        int i = rn.nextInt(diff + 1);
        i += min;

        onView(withId(R.id.recycler_view)).perform(actionOnItemAtPosition(i, click()));
    }

    @Test
    public void testAlertDialogCancelButton() {
        onView(withId(R.id.username_edit_text))
                .perform(typeText(USERNAME_TO_BE_TYPED), closeSoftKeyboard());
        onView(withId(R.id.password_edit_text))
                .perform(typeText(PASSWORD_TO_BE_TYPED), closeSoftKeyboard());
        onView(withId(R.id.login_button)).perform(click());

        onView(withText("OK")).check(matches(isDisplayed()));
        onView(withText("Cancel")).check(matches(isDisplayed()));
        onView(withText("Login Successful")).check(matches(isDisplayed()));

        onView(withText("Cancel")).perform(click());

    }

    @Test
    public void testEmptyUserNamePassword() {
        // No username and password press the button.
        onView(withId(R.id.username_edit_text))
                .perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.password_edit_text))
                .perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.login_button)).perform(click());

        onView(withText("OK")).check(matches(isDisplayed()));
        onView(withText("FIELD_VACCANT")).check(matches(isDisplayed()));

        onView(withText("OK")).perform(click());
    }

    @Test
    public void testInvalidUserName() {
        // Type invalid username and valid password and then press the button.
        onView(withId(R.id.username_edit_text)).perform(typeText(INVALID_USERNAME_TO_BE_TYPED),
                closeSoftKeyboard());
        onView(withId(R.id.password_edit_text)).perform(typeText(PASSWORD_TO_BE_TYPED),
                closeSoftKeyboard());
        onView(withId(R.id.login_button)).perform(click());

        onView(withText("OK")).check(matches(isDisplayed()));
        onView(withText("Invalid Email Id")).check(matches(isDisplayed()));

        onView(withText("OK")).perform(click());
    }

    @Test
    public void testInvalidPassword() {
        // Type valid username and invalid password and then press the button.
        onView(withId(R.id.username_edit_text)).perform(typeText(USERNAME_TO_BE_TYPED),
                closeSoftKeyboard());
        onView(withId(R.id.password_edit_text)).perform(typeText(INVALID_PASSWORD_TO_BE_TYPED),
                closeSoftKeyboard());
        onView(withId(R.id.login_button)).perform(click());

        onView(withText("OK")).check(matches(isDisplayed()));
        onView(withText("Invalid Password")).check(matches(isDisplayed()));

        onView(withText("OK")).perform(click());
    }
}


 /* int titleId = mActivity.getActivity().getResources()
                .getIdentifier("alertTitle", "id", "android");
        onView(withId(titleId))
                .inRoot(isDialog())
                .check(matches(withText("Login Successful")))
                .check(matches(isDisplayed()));*/



 /*onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.scrollToPosition(1),
                RecyclerViewActions.actionOnItemAtPosition(1, click()));*/