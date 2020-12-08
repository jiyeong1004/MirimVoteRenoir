package com.example.mirimvoterenoir;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class GridAdapter extends BaseAdapter {
    Context context;
    int[] imgFileNames = {R.drawable.o1, R.drawable.o2, R.drawable.o3, R.drawable.o4, R.drawable.o5, R.drawable.o6, R.drawable.o7, R.drawable.o8, R.drawable.o9};
    String[] imgNames = {"잠자기", "하트 배달", "사탕", "우산", "하트", "오잉", "Zzz", "토토로랑", "짱구랑"};
    int[] voteCount = new int[imgNames.length];

    public GridAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return imgFileNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgv = new ImageView(context);
        imgv.setLayoutParams(new GridView.LayoutParams(300, 400));
        imgv.setAdjustViewBounds(true);
        imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imgv.setPadding(10, 10, 10, 10);
        imgv.setImageResource(imgFileNames[position]);
        for(int i = 0; i < voteCount.length; i++){
            voteCount[i] = 0;
        }
        final int pos = position;
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voteCount[pos]++;
                Toast.makeText(context, imgNames[pos] + " : 총" + voteCount[pos] + "표", Toast.LENGTH_SHORT).show();
            }
        });
        return imgv;
    }
}