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
public class VocabFragment extends android.support.v4.app.Fragment {
    int activity;
    public VocabFragment(int activity) {
        this.activity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_lession_vocab,container,false);
        
        return rootView;
    }

}
