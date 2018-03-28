package com.mobinius.unittestapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by prajna on 9/11/16.
 */

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class LoginUIAutomatorTest {


    private static final String BASIC_SAMPLE_PACKAGE
            = "com.mobinius.unittestapp";

    private static final int LAUNCH_TIMEOUT = 5000;
    public static final String USERNAME_TO_BE_TYPED = "prajna@gmail.com";
    public static final String PASSWORD_TO_BE_TYPED = "12345678";
    public static final String INVALID_USERNAME_TO_BE_TYPED = "prajna";
    public static final String INVALID_PASSWORD_TO_BE_TYPED = "1255555553";
    public static final String WELCOME = "WELCOME";

    private UiDevice mDevice;

    @Before
    public void startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        mDevice.pressHome();

        // Wait for launcher
        final String launcherPackage = getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);

        // Launch the blueprint app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);    // Clear out any previous instances
        context.startActivity(intent);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)), LAUNCH_TIMEOUT);
    }

    @Test
    public void checkPreconditions() {
        assertThat(mDevice, notNullValue());
    }

    @Test
    public void testValidUserNamePassword() {
        // Type username and password and then press the button.
        mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "username_edit_text"))
                .setText(USERNAME_TO_BE_TYPED);
        mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "password_edit_text"))
                .setText(PASSWORD_TO_BE_TYPED);
        mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "login_button"))
                .click();
        UiObject2 welcomeText = mDevice
                .wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "welcome_text_view")),
                        500 /* wait 500ms */);
        assertThat(welcomeText.getText(), is(equalTo(WELCOME)));

        UiObject2 usernameText = mDevice
                .wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "username_value")),
                        500 /* wait 500ms */);
        assertThat(usernameText.getText(), is(equalTo(USERNAME_TO_BE_TYPED)));

        UiObject2 passwordText = mDevice
                .wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "password_value")),
                        500 /* wait 500ms */);
        assertThat(passwordText.getText(), is(equalTo(PASSWORD_TO_BE_TYPED)));

    }

    @Test
    public void testEmptyUserNamePassword() {
        // No username and password press the button.
        mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "username_edit_text"))
                .setText("");
        mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "password_edit_text"))
                .setText("");
        mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "login_button"))
                .click();

    }

    @Test
    public void testInvalidUserName() {
        // Type invalid username and valid password and then press the button.
        mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "username_edit_text"))
                .setText(INVALID_USERNAME_TO_BE_TYPED);
        mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "password_edit_text"))
                .setText(PASSWORD_TO_BE_TYPED);
        mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "login_button"))
                .click();

    }

    @Test
    public void testInvalidPassword() {
        // Type valid username and invalid password and then press the button.
        mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "username_edit_text"))
                .setText(USERNAME_TO_BE_TYPED);
        mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "password_edit_text"))
                .setText(INVALID_PASSWORD_TO_BE_TYPED);
        mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "login_button"))
                .click();

    }

   /* @Test
    public void testHomeActivity() {
        // Type text and then press the button.
//        mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "editTextUserInput"))
//                .setText(STRING_TO_BE_TYPED);
//        mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "activityChangeTextBtn"))
//                .click();

        // Verify the test is displayed in the Ui
        UiObject2 welcomeText = mDevice
                .wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "welcome_text_view")),
                        500 *//* wait 500ms *//*);
        assertThat(welcomeText.getText(), is(equalTo(WELCOME)));
    }*/

    private String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        // Use PackageManager to get the launcher package name
        PackageManager pm = InstrumentationRegistry.getContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }
}
