package com.example.insorma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


import com.example.insorma.database.Database;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView welcome;
        welcome = findViewById(R.id.helloText);
        welcome.setText("WELCOME" + " " + database.getUserLogin().getUserUsername());


        final ArrayList<HomeListview> arrayList = new ArrayList<HomeListview>();

        arrayList.add(new HomeListview(R.drawable.bedside, "Bedside Drawer", "7.5", "Rp.500.000,00"));
        arrayList.add(new HomeListview(R.drawable.sofaorange, "Orange special sofa", "8", "Rp.900.000,00"));
        arrayList.add(new HomeListview(R.drawable.modernchair, "Modern Chair", "9", "Rp.350.000,00"));
        arrayList.add(new HomeListview(R.drawable.moderndining, "Modern Dining Set", "9", "Rp.1.500.000"));
        arrayList.add(new HomeListview(R.drawable.sofagrey, "Sofa", "8.5", "Rp.700.000,00"));
        arrayList.add(new HomeListview(R.drawable.outdoorfurn, "Special Outdoor Set", "8", "Rp.800.000,00"));

        ListviewAdapter Arrayadapter = new ListviewAdapter(this, arrayList);

        ListView ListViews = findViewById(R.id.listView);


        int[] furnitureImg ={R.drawable.bedside,R.drawable.sofaorange,R.drawable.modernchair,R.drawable.moderndining,R.drawable.sofagrey,R.drawable.outdoorfurn};
        String[] furnitureName = {"Bedside Drawer","Orange special sofa","Modern Chair","Modern Dining Set","Sofa","Special Outdoor Set"};
        String[] furnitureRating = {"7.5","8","9","9","8.5","8"};
        String[] furniturePrice = {"Rp.500.000,00","Rp.900.000,00","Rp.350.000,00","Rp.1.500.000,00","Rp.700.000,00","Rp.800.000,00"};

        ListViews.setAdapter(Arrayadapter);
        ListViews.setClickable(true);

        ListViews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(Home.this, itemDetail.class);
                intent.putExtra("FurnitureImageId", furnitureImg[i]);
                intent.putExtra("FurnitureName", furnitureName[i]);
                intent.putExtra("FurnitureRating", furnitureRating[i]);
                intent.putExtra("FurniturePrice", furniturePrice[i]);
                startActivity(intent);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu1:
                Intent intent = new Intent(this,Home.class);
                startActivity(intent);
                break;
            case R.id.Menu2:
                Intent intent2 = new Intent(this,TransactionHistory.class);
                startActivity(intent2);
                break;
            case R.id.Profile:
                Intent intent1 = new Intent(this,Profile.class);
                startActivity(intent1);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

}