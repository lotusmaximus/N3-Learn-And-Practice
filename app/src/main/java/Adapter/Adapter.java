package Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.myapplication.R;

import java.util.List;

import Model.NewWord;

/**
 * Created by 8470p on 2/20/2016.
 */
public class Adapter extends BaseAdapter {
    List<NewWord> data;
    Context mContext;
    public Adapter(List<NewWord> data, Context mContext){
        super();
        this.data = data;
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return data.size();
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder myHolder = new Holder();
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_newword,parent,false);
            myHolder.tvHiragana = (TextView)convertView.findViewById(R.id.hiragana);
            myHolder.tvMean = (TextView)convertView.findViewById(R.id.mean);
            myHolder.im_favorite = (ImageView) convertView.findViewById(R.id.favorite);
            convertView.setTag(myHolder);
        }
        myHolder = (Holder) convertView.getTag();
        myHolder.im_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.get(position).setFavorite(!data.get(position).isFavorite());
                notifyDataSetChanged();

            }
        });
        if(data.get(position).isFavorite()){
            myHolder.im_favorite.setImageResource(R.drawable.ic_star_white);
            notifyDataSetChanged();
        }
        else {
            myHolder.im_favorite.setImageResource(R.drawable.ic_star_border);
            notifyDataSetChanged();
        }
        myHolder.tvHiragana.setText(data.get(position).getHiragana()+" - "+data.get(position).getKanji());
        myHolder.tvMean.setText(data.get(position).getVie()+ " - " + data.get(position).getEnd());


        return convertView;
    }

    public class Holder{
        public TextView tvHiragana;
        public TextView tvMean;
        ImageView im_favorite;
    }
}
