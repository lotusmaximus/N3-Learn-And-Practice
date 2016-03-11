package Fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.com.myapplication.Lession1Activity;
import com.example.com.myapplication.Lession2Activity;
import com.example.com.myapplication.Lession3Activity;
import com.example.com.myapplication.Lession4Activity;
import com.example.com.myapplication.Lession5Activity;
import com.example.com.myapplication.Lession6Activity;
import com.example.com.myapplication.Lession7Activity;
import com.example.com.myapplication.Lession8Activity;
import com.example.com.myapplication.R;

/**
 * Created by 8470p on 2/18/2016.
 */
public class PracticeFragment extends Fragment {
    LinearLayout l1,l2,l3,l4,l5,l6,l7,l8;
    Activity mContext;

    @Override
    public void onAttach(Activity activity) {
        this.mContext = activity;
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_practice,container,false);
        initView(rootView);
        initEvent(rootView);
        return rootView;
    }
    public void initView(View v){
        l1 = (LinearLayout) v.findViewById(R.id.l1);
        l2 = (LinearLayout) v.findViewById(R.id.l2);
        l3 = (LinearLayout) v.findViewById(R.id.l3);
        l4 = (LinearLayout) v.findViewById(R.id.l4);
        l5 = (LinearLayout) v.findViewById(R.id.l5);
        l6 = (LinearLayout) v.findViewById(R.id.l6);
        l7 = (LinearLayout) v.findViewById(R.id.l7);
        l8 = (LinearLayout) v.findViewById(R.id.l8);
    }
    public void initEvent(View v){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.l1:
                        startActivity(new Intent(mContext.getApplicationContext(), Lession1Activity.class));
                        break;
                    case R.id.l2:
                        startActivity(new Intent(mContext.getApplicationContext(), Lession2Activity.class));
                        break;
                    case R.id.l3:
                        startActivity(new Intent(mContext.getApplicationContext(), Lession3Activity.class));
                        break;
                    case R.id.l4:
                        startActivity(new Intent(mContext.getApplicationContext(), Lession4Activity.class));
                        break;
                    case R.id.l5:
                        startActivity(new Intent(mContext.getApplicationContext(), Lession5Activity.class));
                        break;
                    case R.id.l6:
                        startActivity(new Intent(mContext.getApplicationContext(), Lession6Activity.class));
                        break;
                    case R.id.l7:
                        startActivity(new Intent(mContext.getApplicationContext(), Lession7Activity.class));
                        break;
                    case R.id.l8:
                        startActivity(new Intent(mContext.getApplicationContext(), Lession8Activity.class));
                        break;
                }
            }
        };
        l1.setOnClickListener(listener);
        l2.setOnClickListener(listener);
        l3.setOnClickListener(listener);
        l4.setOnClickListener(listener);
        l5.setOnClickListener(listener);
        l6.setOnClickListener(listener);
        l7.setOnClickListener(listener);
        l8.setOnClickListener(listener);

    }
}
