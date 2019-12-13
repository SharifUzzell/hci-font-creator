package com.example.yourfont;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link saved_fonts.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link saved_fonts#newInstance} factory method to
 * create an instance of this fragment.
 */
public class saved_fonts extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public saved_fonts() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment saved_fonts.
     */
    // TODO: Rename and change types and number of parameters
    public static saved_fonts newInstance(String param1, String param2) {
        saved_fonts fragment = new saved_fonts();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved_fonts, container, false);
    }

    @Override
    public void onViewCreated (View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        fillLayout(view);
    }

    public void fillLayout(View view) {
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.savedFontsLinearLayout);

        for (int x = 1; x < 30; x++) {
            // Relative Layout
            RelativeLayout relativeLayout = new RelativeLayout(getContext());

            //Relative layout params
            RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            //Alternating background color
            if(x % 2 != 0)
                relativeLayout.setBackgroundColor(Color.parseColor("#A8CCFF"));

            ////////////////////////////////////////
            // Creating first TextView            //
            ////////////////////////////////////////
            final TextView exportText = new TextView(getContext());
            exportText.setText(" Export ");

            // Setting params
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            lp.addRule(RelativeLayout.CENTER_VERTICAL);
            lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            lp.topMargin = 20;
            lp.bottomMargin = 20;
            lp.rightMargin = 50;
            exportText.setId(x);
            exportText.setBackgroundColor(Color.parseColor("#A8FFFE"));
            exportText.setLayoutParams(lp);

            //set on click
            exportText.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Toast.makeText(getContext(),"exportButton " + exportText.getId(),Toast.LENGTH_SHORT).show();
                }
            });

            ////////////////////////////////////////

            ////////////////////////////////////////
            // Creating second TextView           //
            ////////////////////////////////////////
            // Creating a new TextView
            TextView editText = new TextView(getContext());
            editText.setText(" Edit ");

            // Defining the layout parameters of the TextView
            RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            lp2.addRule(RelativeLayout.CENTER_VERTICAL);
            lp2.addRule(RelativeLayout.LEFT_OF, exportText.getId());
            lp2.topMargin = 20;
            lp2.bottomMargin = 20;
            lp2.rightMargin = 50;
            editText.setBackgroundColor(Color.parseColor("#A8FFFE"));
            editText.setLayoutParams(lp2);

            //set on click
            editText.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    Toast.makeText(getContext(),"editButton " + exportText.getId(),Toast.LENGTH_SHORT).show();
                }
            });

            ////////////////////////////////////////

            ////////////////////////////////////////
            // Creating third TextView            //
            ////////////////////////////////////////
            // Creating a new TextView
            TextView fontNameText = new TextView(getContext());
            fontNameText.setText("Sample Font " + x);

            // Defining the layout parameters of the TextView
            RelativeLayout.LayoutParams lp3 = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            lp3.addRule(RelativeLayout.CENTER_VERTICAL);
            lp3.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            lp3.topMargin = 20;
            lp3.bottomMargin = 20;
            lp3.leftMargin = 100;

            // Setting the parameters on the TextView
            fontNameText.setLayoutParams(lp3);
            ////////////////////////////////////////

            // Add text views to layout
            relativeLayout.addView(fontNameText);
            relativeLayout.addView(editText);
            relativeLayout.addView(exportText);

            //add relative layout to scrollable list
            layout.addView(relativeLayout);
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
