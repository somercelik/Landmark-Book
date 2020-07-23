package com.somercelik.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        final ArrayList<String> landMarkNames = new ArrayList<>();
        landMarkNames.add("İnceburun Feneri");
        landMarkNames.add("Erfelek Tatlıca Şelaleleri");
        landMarkNames.add("Sinop Tarihi Cezaevi");
        landMarkNames.add("Çakallı Köyü");

        final ArrayList<String> countryNames = new ArrayList<>();
        countryNames.add("Turkey");
        countryNames.add("Koh Samui Island");
        countryNames.add("United Arab Emirates");
        countryNames.add("Turkey");
        //Drawable paketindeki resimleri bitmap tipinde değişkenlere aldık.
        Bitmap inceburun = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.inceburun);
        Bitmap tatlica = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.tatlica);
        Bitmap cezaevi = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.cezaevi);
        Bitmap cakalli = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.cakalli);

        final ArrayList<Bitmap> landmarkImages = new ArrayList<>();
        landmarkImages.add(inceburun);
        landmarkImages.add(tatlica);
        landmarkImages.add(cezaevi);
        landmarkImages.add(cakalli);

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, landMarkNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int listIndex, long l) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("landmarkName", landMarkNames.get(listIndex));
                intent.putExtra("countryName", countryNames.get(listIndex));

                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(landmarkImages.get(listIndex));
                startActivity(intent);
            }
        });

    }
}