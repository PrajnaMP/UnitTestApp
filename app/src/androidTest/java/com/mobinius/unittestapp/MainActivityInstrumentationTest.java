/*
package com.mobinius.unittestapp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

*/
/**
 * Created by prajna on 4/11/16.
 *//*


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentationTest {
    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void sayHello() {
        //onView(withText("Say hello!")).perform(click());
// Verify the test is displayed in the Ui
        onView(withId(R.id.textview_hello)).check(matches(withText("Hello, World!")));

        onView(withId(R.id.textview_hello)).perform(typeText("wonderful and lovely "), closeSoftKeyboard());
//       onView(withId(R.id.textview_hello)).perform(click());
    }
}*/
