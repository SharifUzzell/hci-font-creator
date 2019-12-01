package com.example.yourfont;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements tutorial.OnFragmentInteractionListener, camera_view.OnFragmentInteractionListener,
        splash_page.OnFragmentInteractionListener, saved_fonts.OnFragmentInteractionListener, edit_font.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }
}
