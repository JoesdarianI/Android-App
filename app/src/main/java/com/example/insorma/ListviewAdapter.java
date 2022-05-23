package com.example.insorma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class ListviewAdapter extends ArrayAdapter<HomeListview> {

    public ListviewAdapter(@NonNull Context context, ArrayList<HomeListview> arrayList){
        super(context,0,arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,@Nullable ViewGroup parent){
        View currentItemView = convertView;

        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.homelistview, parent, false);
        }

        HomeListview currentPosition =getItem(position);

        ImageView numberImage = currentItemView.findViewById(R.id.imageVIew);
        assert currentPosition != null;
        numberImage.setImageResource(currentPosition.getLvImage());

        TextView textView1 = currentItemView.findViewById(R.id.fName);
        textView1.setText(currentPosition.getLvFname());

        TextView textView2 = currentItemView.findViewById(R.id.fRating);
        textView2.setText(currentPosition.getLvFrating());

        TextView textView3 = currentItemView.findViewById(R.id.fPrice);
        textView3.setText(currentPosition.getLvFprice());



        return currentItemView;

    }
}
