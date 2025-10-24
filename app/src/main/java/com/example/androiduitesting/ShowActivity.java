package com.example.androiduitesting;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show);

        TextView textView = findViewById(R.id.textView_cityName);
        String cityName = getIntent().getStringExtra("city_name");
        textView.setText(cityName);

        Button backButton = findViewById(R.id.button_back);
        backButton.setOnClickListener(v -> finish());
    }
}