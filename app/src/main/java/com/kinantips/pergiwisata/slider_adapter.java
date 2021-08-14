package com.kinantips.pergiwisata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
/**
 12 Agustus 2021
 10118426
 Kinanti Trimutiara Putri Setiawan
 IF-10
 */
public class slider_adapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public slider_adapter(Context context) {this.context = context; }

    int images[] = {
            R.drawable.logo,
            R.drawable.map,
            R.drawable.info
    };

    int title[] = {
            R.string.slide_title_1,
            R.string.slide_title_2,
            R.string.slide_title_3
    };

    int desc[] = {
            R.string.slide_desc_1,
            R.string.slide_desc_2,
            R.string.slide_desc_3
    };

    @Override
    public int getCount() { return title.length; }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slides_layout,container,false);

        //hooks
        ImageView imageView = view.findViewById(R.id.img1);
        TextView textView = view.findViewById(R.id.txt1);
        TextView subTextView = view.findViewById(R.id.subTxt1);

        imageView.setImageResource(images[position]);
        textView.setText(title[position]);
        subTextView.setText(desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
