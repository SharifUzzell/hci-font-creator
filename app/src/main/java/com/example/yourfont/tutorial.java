package com.example.yourfont;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link tutorial.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link tutorial#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tutorial extends Fragment {

    private OnFragmentInteractionListener mListener;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    private LinearLayout mDotLayout;
    private Button mNextBtn;
    private Button mBackBtn;
    private int mCurrentPage;


    public tutorial() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parametersn .
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tutorial.
     */
    // TODO: Rename and change types and number of parameters
    public static tutorial newInstance(String param1, String param2) {
        tutorial fragment = new tutorial();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tutorial, container, false);
    }

    @Override
    public void onViewCreated (View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        ViewPager mSlideViewPager = (ViewPager) view.findViewById(R.id.slideViewPager);
        sliderAdapter = new SliderAdapter(this.getContext());
        mSlideViewPager.setAdapter(sliderAdapter);
        mDotLayout = (LinearLayout) view.findViewById(R.id.dotsLayout);

        mNextBtn = (Button) view.findViewById(R.id.nextBtn);
        mBackBtn = (Button) view.findViewById(R.id.prevBtn);

        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);

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

    public void addDotsIndicator(int position){
        mDots = new TextView[3];
        for(int i = 0; i < mDots.length; i++){
            mDots[i] = new TextView(this.getContext());
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentBlue));
            mDotLayout.addView(mDots[i]);
        }
        if(mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorBlue));
        }

    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.SimpleOnPageChangeListener(){
        @Override
        public void onPageScrolled(int i, float v, int i1){

        }
        @Override
        public void onPageSelected(int i){
            addDotsIndicator(i);
            mCurrentPage = i;
            if(i == 0 ){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
                mBackBtn.setVisibility(View.INVISIBLE);
                mNextBtn.setText("Next");
                mBackBtn.setText("");


            }else if (i == mDots.length - 1){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mNextBtn.setText("Finish");
                mBackBtn.setText("Back");
            }else{
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mNextBtn.setText("Next");
                mBackBtn.setText("Back  ");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i){

        }
    };

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
