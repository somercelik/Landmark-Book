package com.somercelik.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    ImageView imageView;
    TextView landmarkNameText, countryNameText;
    String landmarkName, countryName;
    Bitmap landmarkImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageView = findViewById(R.id.imageView);
        landmarkNameText = findViewById(R.id.landmarkNameText);
        countryNameText = findViewById(R.id.countryNameText);

        Intent intent = getIntent();
        landmarkName = intent.getStringExtra("landmarkName");
        countryName = intent.getStringExtra("countryName");
        landmarkNameText.setText(landmarkName);
        countryNameText.setText(countryName);
        Singleton singleton = Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosenImage());
    }
}