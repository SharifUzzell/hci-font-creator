package com.example.yourfont;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }
    public int[] slide_images ={
        R.drawable.write_img,
        R.drawable.camera_img,
        R.drawable.save_img };

    public String[] slide_headings = {
            "STEP 1",
            "STEP 2",
            "STEP 3"};

    public String[] slide_descs = {
       "Write the given uppercase prompt on a sheet of blank paper: \n \"THE QUICK BROWN FOX JUMPED OVER THE LAZY DOG \"",
       "Capture the sentence with the camera",
       "Repeat steps 1 and 2 for the lowercase prompt: \n \"the quick brown fox jumped over the lazy dog\"  \n You then be able to edit and save your font"};
    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        LayoutInflater l = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = l.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);
        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((ConstraintLayout)object);
    }


}
