package com.example.monitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnSave(View view) {

        Log.i(TAG,"Записаны имя и возраст");

        EditText userName = findViewById(R.id.userName);
        EditText userAge = findViewById(R.id.userAge);

        String name = userName.getText().toString();
        String stringAge = userAge.getText().toString();

        if (name.isEmpty()) {
            Toast.makeText(this, getString(R.string.error_name), Toast.LENGTH_LONG).show();
        }
        if (stringAge.isEmpty()) {
            Toast.makeText(this, getString(R.string.error_age), Toast.LENGTH_LONG).show();
        } else {
            try {
                int age = Integer.parseInt(stringAge);
            } catch (Exception e) {
                Toast.makeText(this, getString(R.string.error_age_nub), Toast.LENGTH_LONG).show();
                Log.e(TAG,"Получено исключение",e);
            }
        }
    }

    public void btnPressure(View view) {
        Log.i(TAG,"Открыты параметры давления");
        Intent intent = new Intent(MainActivity.this, Pressure.class);
        startActivity(intent);
    }

    public void btnHealth(View view) {
        Log.i(TAG,"Открыты параметры здоровья");
        Intent intent = new Intent(MainActivity.this, Health.class);
        startActivity(intent);
    }
}