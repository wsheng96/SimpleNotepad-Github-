package com.inti.student.simplenotepad;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterPasswordActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);

        //Load the password
        SharedPreferences settings = getSharedPreferences("PRESS", 0);
        password = settings.getString("password", "");

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();

                if (text.equals(password)) {
                    //Enter the app
                    Intent intent = new Intent(getApplicationContext(), MyNotes.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(EnterPasswordActivity.this, "Wrong password!",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
