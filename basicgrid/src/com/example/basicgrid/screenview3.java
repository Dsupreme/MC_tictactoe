package com.example.basicgrid;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class screenview3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.tutorial, container, false);
        
        final ImageView animImageView = (ImageView) rootView.findViewById(R.id.ivAnimation);
        animImageView.setBackgroundResource(R.drawable.anim3);
        final TextView tv3 = (TextView)rootView.findViewById(R.id.text_vp);
        tv3.setText("Anytime you get 3 in a row/column/diagonal in any mini board, you win in that board.");
        animImageView.post(new Runnable() {
            @Override
            public void run() {
                AnimationDrawable frameAnimation =
                    (AnimationDrawable) animImageView.getBackground();
                frameAnimation.start();
            }
        });
        return rootView;
        }
}
