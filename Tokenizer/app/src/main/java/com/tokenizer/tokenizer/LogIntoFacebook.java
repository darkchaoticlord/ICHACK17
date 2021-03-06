package com.tokenizer.tokenizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LogIntoFacebook extends AppCompatActivity {

    private String TAG = "LogIntoFacebook";
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_log_into_facebook);

        callbackManager = CallbackManager.Factory.create();

        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setGravity(Gravity.CENTER);

        loginButton.setReadPermissions("email");
        // If using in a fragment
        // Other app specific specialization

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                String token = loginResult.getAccessToken().getToken();
                try {
                    URL url = new URL("");
                    HttpURLConnection client = (HttpURLConnection) url.openConnection();
                    client.setDoOutput(true);
                    client.connect();
                    client.getOutputStream().write(Byte.valueOf(token));
                    byte[] bytes = new byte[64];
                    client.getInputStream().read(bytes);
                    MainActivity.token = bytes;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(LogIntoFacebook.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {
                onCreate(savedInstanceState);
            }

            @Override
            public void onError(FacebookException exception) {
                Log.e(TAG, exception.toString());
            }

        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, data.toString());
    }
}
