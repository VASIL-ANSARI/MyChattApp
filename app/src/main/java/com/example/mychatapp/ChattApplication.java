package com.example.mychatapp;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.Parse;
import com.parse.ParseObject;

import model.Message;

public class ChattApplication extends Application {
    public static final String APP_KEY_ID = "g52JNeNg35fbaBLrqKFkYxiEym6QVEkZXX77L4LZ";
    public static final String APP_CLIENT_ID = "Tpv014f31Z89QiiyrI1tONruebPSd61S279Jx8Eu";

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(ChattApplication.this);

        ParseObject.registerSubclass(Message.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(APP_KEY_ID) // should correspond to APP_ID env variable
                .clientKey(APP_CLIENT_ID) // set explicitly unless clientKey is explicitly configured on Parse server
                .server("https://parseapi.back4app.com/").build());
    }
}
