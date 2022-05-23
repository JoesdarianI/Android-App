package com.example.insorma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class itemDetail extends AppCompatActivity {

    private TextView itemName,itemPrice,itemRating;
    private ImageView itemImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        ArrayList<HomeListview> item;

        itemImg = findViewById(R.id.detailImg);
        itemName = findViewById(R.id.detailName);
        itemRating = findViewById(R.id.detailRating);
        itemPrice=findViewById(R.id.detailPrice);

        item =(ArrayList<HomeListview>)getIntent().getSerializableExtra("data");

        int image = getIntent().getIntExtra("FurnitureImageId",R.drawable.bedside);
        String name= getIntent().getStringExtra("FurnitureName");
        String rating= getIntent().getStringExtra("FurnitureRating");
        String price =getIntent().getStringExtra("FurniturePrice");


        itemImg.setImageResource(image);
        itemName.setText(name);
        itemRating.setText(rating);
        itemPrice.setText(price);
    }
}