package com.example.com.lessionfragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.com.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.Adapter;
import DB.MyDBHelper;
import Model.NewWord;

/**
 * Created by 8470p on 2/18/2016.
 */
public class NewwordFragment extends android.support.v4.app.Fragment {

    Context mContext;
    int activity;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    public  NewwordFragment(int activity){
        this.activity = activity;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_lession_newword, container, false);
        MyDBHelper myDBHelper = new MyDBHelper(mContext);
        myDBHelper.copyAssets();
        myDBHelper.openDataBase();
        List<NewWord> listNewword  = myDBHelper.getCategoryHelper().getListCategory();
        ListView lvNewword = (ListView) rootView.findViewById(R.id.lvNewword);
        lvNewword.setAdapter(new Adapter(listNewword,mContext));
        lvNewword.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showCustomDialog();
                return false;
            }
        });
        return rootView;
    }
    private void showCustomDialog(){
        final Dialog dialog = new Dialog(mContext, android.R.style.Theme_Translucent_NoTitleBar);
        dialog.setContentView(R.layout.activity_custom_dialog_login);
        dialog.setCancelable(true);

        dialog.getWindow().getAttributes().windowAnimations = android.R.style.Animation_Dialog;
        dialog.findViewById(R.id.layoutParent).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });
        dialog.findViewById(R.id.btCancel).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
