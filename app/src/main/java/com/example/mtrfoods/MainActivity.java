package com.example.mtrfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edUsername;
    EditText edPassword;
    TextView txtError;
    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edUsername = findViewById(R.id.EditText_Username);
        edPassword = findViewById(R.id.EditText_password);
        txtError = findViewById(R.id.txt_error);
    }

    public void loginEvent(View view) {
        if(edUsername.getText().toString().equals("") && edPassword.getText().toString().equals("")){
            txtError.setText("Enter Username and Password !");
        }
        else if(edUsername.getText().toString().equals("") && edPassword.getText().toString() != ""){
            txtError.setText("Enter Username !");
        }
        else if(edUsername.getText().toString() != "" && edPassword.getText().toString().equals("")){
            txtError.setText("Enter Password !");
        }
        else if(edUsername.getText().toString().equals("123") && edPassword.getText().toString().equals("123")){
            Intent intent = new Intent(this, HomeActivity.class);
            String name = edUsername.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, name);
            startActivity(intent);
        }
        else{
            txtError.setText("Incorrect Username and Password !");
        }

    }
}
