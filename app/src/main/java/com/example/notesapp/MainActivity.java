package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.notesapp", Context.MODE_PRIVATE);
        if(!sharedPreferences.getString("username", "").equals("")){
            String storedname = sharedPreferences.getString("username", "");
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("username", storedname);
            startActivity(intent);
        }
        else {
            setContentView(R.layout.activity_main);
        }
    }

    public void onClickLogin(View view) {
        EditText nameField = (EditText) findViewById(R.id.username);
        String username = nameField.getText().toString();
        //saving username
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.notesapp", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", username).apply();
        //going to the second activity
        goToActivity2(username);
    }

    protected void goToActivity2(String username) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }
}