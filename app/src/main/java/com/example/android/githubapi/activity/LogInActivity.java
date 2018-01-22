package com.example.android.githubapi.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.githubapi.R;

public class LogInActivity extends AppCompatActivity {

    private Button logIn;
    private EditText inputUserName;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        logIn = (Button) findViewById(R.id.btn_login);
        inputUserName = (EditText) findViewById(R.id.input_username);
    }

    public void getUser(View view){

        i = new Intent(LogInActivity.this, UserActivity.class);
        i.putExtra("STRING_I_NEED", inputUserName.getText().toString());
        startActivity(i);
    }
}
