package com.example.victorbello.twittercliente;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.support.design.widget.Snackbar;


import com.example.victorbello.twittercliente.main.ui.MainActivity;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterSession;

public class LoginActivity extends AppCompatActivity {

    private RelativeLayout container;
    private TwitterLoginButton twitterLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        container=(RelativeLayout) findViewById(R.id.container);
        twitterLoginButton=(TwitterLoginButton) findViewById(R.id.twitterLogButton);

        if(Twitter.getSessionManager().getActiveSession()!=null){
            navigateToMainScreen();
        }

        twitterLoginButton.setCallback(new Callback<TwitterSession>(){

            @Override
            public void success(Result<TwitterSession> result) {
                navigateToMainScreen();
            }

            @Override
            public void failure(TwitterException exception) {
                String msgError=String.format(getString(R.string.login_error_message),exception.getLocalizedMessage());
                Snackbar.make(container,msgError,Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode,data);
        twitterLoginButton.onActivityResult(requestCode,resultCode,data);
    }

    private void navigateToMainScreen(){
        Intent intent=new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                |Intent.FLAG_ACTIVITY_NEW_TASK
                |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
