package com.example.monitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Pressure extends AppCompatActivity {

    private static final String TAG = "Pressure";
    private List<IndicatorsPressure> indicatorsPressures = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
    }

    public void btnSave(View view) {

        Log.i(TAG,"Записаны данные давления");

        EditText topPressure = findViewById(R.id.topPressure);
        EditText lowerPressure = findViewById(R.id.lowerPressure);
        EditText pulse = findViewById(R.id.pulse);
        CheckBox tachycardia = findViewById(R.id.tachycardia);
        EditText froze = findViewById(R.id.froze);

        boolean blTachycardia = tachycardia.isChecked();
        try {
            int intTopPressure = Integer.parseInt(topPressure.getText().toString());
            int intLowerPressure = Integer.parseInt(lowerPressure.getText().toString());
            int intPulse = Integer.parseInt(pulse.getText().toString());
            LocalDateTime ldFrose = LocalDateTime.parse(froze.getText().toString());

            IndicatorsPressure indicatorsPressure = new IndicatorsPressure(intTopPressure, intLowerPressure, intPulse, blTachycardia, ldFrose);
            indicatorsPressures.add(indicatorsPressure);

        } catch (Exception e) {
            Toast.makeText(this, getString(R.string.error_all), Toast.LENGTH_LONG).show();
            Log.e(TAG,"Получено исключение",e);
        }

    }

    public void btnReturn(View view) {
        Log.i(TAG, "Возврат на главный экран");
        finish();
    }
}