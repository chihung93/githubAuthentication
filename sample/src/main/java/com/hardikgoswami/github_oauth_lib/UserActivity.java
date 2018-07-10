package com.hardikgoswami.github_oauth_lib;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class UserActivity extends Activity {

    SharedPreferences sharedPreferences;
    public static final String TAG = UserActivity.class.getSimpleName();
    public static final String PREFERENCE = "github_prefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        sharedPreferences = getSharedPreferences(PREFERENCE, 0);
        String oauthToken = sharedPreferences.getString("oauth_token", null);
        ((TextView)findViewById(R.id.result)).setText(oauthToken);
        Log.d(TAG, "oauth token for github loged in user is :" + oauthToken);
    }
}
