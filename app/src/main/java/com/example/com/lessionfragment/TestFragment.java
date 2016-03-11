package com.example.com.lessionfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.com.myapplication.R;

/**
 * Created by 8470p on 2/18/2016.
 */
public class TestFragment extends android.support.v4.app.Fragment {
    int activity;
    public TestFragment(int activity) {
        this.activity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = null;
        switch (activity){
            case 1:
                rootView = inflater.inflate(R.layout.fragment_lession_test,container,false);
                break;
            case 2:
                rootView = inflater.inflate(R.layout.fragment_lession_test_2,container,false);
                break;
            case 3:
               rootView = inflater.inflate(R.layout.fragment_lession_test_3,container,false);
                break;
            case 4:
                rootView = inflater.inflate(R.layout.fragment_lession_test_4,container,false);
                break;
            case 5:
                rootView = inflater.inflate(R.layout.fragment_lession_test_5,container,false);
                break;
            case 6:
                rootView = inflater.inflate(R.layout.fragment_lession_test_6,container,false);
                break;
            case 7:
                rootView = inflater.inflate(R.layout.fragment_lession_test_7,container,false);
                break;
            case 8:
                rootView = inflater.inflate(R.layout.fragment_lession_test_8,container,false);
                break;
        }

        
        return rootView;
    }

}
