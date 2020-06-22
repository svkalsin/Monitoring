package com.example.monitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Health extends AppCompatActivity {

    private static final String TAG = "Health";
    private List<IndicatorsHealth> indicatorsHealths = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
    }

    public void btnSave(View view) {
        Log.i(TAG, "Сохранены параметры здоровья");
        EditText weight = findViewById(R.id.weight);
        EditText steps = findViewById(R.id.steps);

        try {
            float fWeight = Float.parseFloat(weight.getText().toString());
            int iSteps = Integer.parseInt(steps.getText().toString());

            IndicatorsHealth indicatorsHealth = new IndicatorsHealth(fWeight, iSteps);
            indicatorsHealths.add(indicatorsHealth);

        } catch (Exception e) {
            Toast.makeText(this, getString(R.string.error_all), Toast.LENGTH_LONG).show();
            Log.e(TAG, "Получено исключение", e);
        }

    }

    public void btnReturn(View view) {
        Log.i(TAG, "Возврат на главный экран");
        finish();
    }
}