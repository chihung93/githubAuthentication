package com.hardikgoswami.github_oauth_lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hardikgoswami.oauthLibGithub.GithubOauth;

public class MainActivity extends AppCompatActivity {

    Button loginButton;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton = (Button) findViewById(R.id.login_btn);
        context = getApplicationContext();
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GithubOauth
                        .Builder()
                        .withClientId("")
                        .withClientSecret("")
                        .withContext(MainActivity.this)
                        .debug(false)
                         .execute();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1000) {
            Toast.makeText(this,data.getStringExtra("oauth_token"),Toast.LENGTH_LONG).show();
        }
    }
}
