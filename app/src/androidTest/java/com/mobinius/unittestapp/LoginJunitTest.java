package com.mobinius.unittestapp;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import junit.framework.Assert;

/**
 * Created by prajna on 9/11/16.
 */

public class LoginJunitTest extends ActivityInstrumentationTestCase2<LoginActivity> {
    LoginActivity mActivity;
    HomePageActivity hActivity;
    private EditText username;
    private EditText password;
    private Button login;
    private TextView welcome, name, pass;

    @SuppressWarnings("deprecation")
    public LoginJunitTest() {
        super("com.mobinius.unittestapp", LoginActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mActivity = this.getActivity();
        username = (EditText) mActivity.findViewById(R.id.username_edit_text);
        password = (EditText) mActivity.findViewById(R.id.password_edit_text);
        login = (Button) mActivity.findViewById(R.id.login_button);
//        welcome = (TextView)findViewById(R.id.welcome_text_view);
//        name = (TextView) hActivity.findViewById(R.id.username_value);
//        pass = (TextView) hActivity.findViewById(R.id.password_value);
    }

    public void testPreconditions() {
     /*   assertEquals("Wrong infor", "Hello", "Hello");
        assertNotNull(username.getText().toString());
        assertNotNull(password.getText().toString());*/
        assertNotNull(username);
        assertNotNull(password);
//        assertNotNull(welcome);
    }

    public void testText() {
        assertEquals("", username.getText().toString());
        assertEquals("", password.getText().toString());
    }


    @UiThreadTest
    public void testValidUserNamePassword() {
        username.requestFocus();
        username.setText("prajna@gmail.com");
        password.requestFocus();
        password.setText("12345678");
        login.callOnClick();
       /* assertEquals("WELCOME", welcome.getText().toString());
        assertEquals("prajna@gmail.com", username.getText().toString());
        assertEquals("12345678", password.getText().toString());*/
    }

    @UiThreadTest
    public void testEmptyUserNamePassword() {
        username.requestFocus();
        username.setText("");
        password.requestFocus();
        password.setText("");
        login.callOnClick();
    }

    @UiThreadTest
    public void testInvalidUserName() {
        this.username.setText("123");
        this.password.setText("12345678");
        Assert.assertTrue(this.login.performClick());
//      Assert.assertTrue(this.mActivity.isFinishing());
    }

    @UiThreadTest
    public void testInvalidPassword() {
        this.username.setText("prajna@gmail.com");
        this.password.setText("123");
        Assert.assertTrue(this.login.performClick());
    }

   /* public void testHomeActivity() {
//        welcome.setText("WELCOME");
        assertEquals("WELCOME", welcome.getText().toString());
        assertEquals("prajna@gmail.com", username.getText().toString());
        assertEquals("12345678", password.getText().toString());

    }*/
}
   /* public void testTextField() {
        // simulate user action to input some value into EditText:
        mActivity.runOnUiThread(new Runnable() {
            public void run() {
                username.setText("helloooo@gmail.com");
                password.setText("hello123");
                // Check if the EditText is properly set:
                try {
                    assertEquals("hello@gmail.com", username.getText().toString());
                    assertEquals("hello123", password.getText().toString());
                }catch (ComparisonFailure ex){
                   Toast.makeText(mActivity,"Not", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @UiThreadTest
    public void testUsernameTextFocus() {
        assertNotNull(username);
        assertTrue(username.requestFocus());
        assertTrue(username.hasFocus());
    }

    @UiThreadTest
    public void testPasswordTextFocus() {
        assertNotNull(password);
        assertTrue(password.requestFocus());
        assertTrue(password.hasFocus());
    }*/