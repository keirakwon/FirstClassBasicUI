package com.example.soon.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.Set;


public class MainActivity extends Activity {

    static final String inputIdKey ="inputIdKey";
    static final String inputPasswdKey ="inputPasswdKey";
    EditText inputId;
    EditText inputPasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            Log.i("BundleIsNull", savedInstanceState +"");
        } else {
            Log.i("BundleIsNotNull", inputIdKey + " is " + savedInstanceState.getString(inputIdKey));
            Log.i("BundleIsNotNull", inputPasswdKey + " is " + savedInstanceState.getString(inputPasswdKey));

            //onSaveInstanceState() 오버라이드 안했을때
           /* Set<String> keys = savedInstanceState.keySet();
            for(String key : keys){
                Log.i("BundleIsNotNull", key);
            }*/
        }

        setContentView(R.layout.activity_main);

        inputId = (EditText)findViewById(R.id.inputId);
        inputPasswd = (EditText)findViewById(R.id.inputPasswd);

    }

    /*http://developer.android.com/training/basics/activity-lifecycle/recreating.html*/
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){

        savedInstanceState.putString(inputIdKey, inputId.getText().toString());
        savedInstanceState.putString(inputPasswdKey, inputPasswd.getText().toString());
        super.onSaveInstanceState(savedInstanceState);

        Log.i("SavedInstanceSate", savedInstanceState.getString(inputIdKey) + " / "+savedInstanceState.getString(inputPasswdKey));
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        Log.i("RestoreInstanceState", savedInstanceState.getString(inputIdKey) + " / "+savedInstanceState.getString(inputPasswdKey));

    }

    public void gotoSecondPage(View view) throws Exception {
        Intent intent = new Intent(this,secondActivity.class);
        startActivity(intent);
    }

}
