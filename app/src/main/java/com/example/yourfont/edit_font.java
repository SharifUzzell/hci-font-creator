package com.example.yourfont;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link edit_font.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link edit_font#newInstance} factory method to
 * create an instance of this fragment.
 */
public class edit_font extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public edit_font() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment edit_font.
     */
    // TODO: Rename and change types and number of parameters
    public static edit_font newInstance(String param1, String param2) {
        edit_font fragment = new edit_font();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_font, container, false);
    }

    @Override
    public void onViewCreated (View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        fillGrid(view);
    }

    public void fillGrid(View view) {
        GridLayout gridLayout = view.findViewById(R.id.editGrid);

        for (int i = 0; i < 26; i++) {
            Button letterButton = new Button(getContext());

            // Defining the layout parameters of the TextView
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            lp.addRule(RelativeLayout.CENTER_VERTICAL);
            lp.width = (int)getResources().getDimension(R.dimen.editButton);
            lp.height = (int)getResources().getDimension(R.dimen.editButton);
            lp.setMargins(10,10,10,10);
            if(i % 2 == 0) {
                lp.leftMargin = 20;
            }

            letterButton.setLayoutParams(lp);
            letterButton.setText(Character.toString((char) (i + 65)));
            letterButton.setBackgroundResource(R.drawable.savedfilebutton);

            gridLayout.addView(letterButton);


            Button letterButton2 = new Button(getContext());

            // Defining the layout parameters of the TextView
            RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            lp2.addRule(RelativeLayout.CENTER_VERTICAL);
            lp2.width = (int)getResources().getDimension(R.dimen.editButton);
            lp2.height = (int)getResources().getDimension(R.dimen.editButton);
            lp2.setMargins(10,10,10,10);
            if(i % 2 != 0) {
                lp2.rightMargin = 20;
            }

            letterButton2.setTransformationMethod(null);
            letterButton2.setLayoutParams(lp2);
            letterButton2.setText(Character.toString((char) (i + 97)));
            letterButton2.setBackgroundResource(R.drawable.savedfilebutton);

            gridLayout.addView(letterButton2);
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
