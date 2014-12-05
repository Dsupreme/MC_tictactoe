package com.example.basicgrid;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class screenview2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.tutorial, container, false);
        
        final ImageView animImageView = (ImageView) rootView.findViewById(R.id.ivAnimation);
        final TextView tv2 = (TextView)rootView.findViewById(R.id.text_vp);
        tv2.setText("Player 2 is guided to a small board based on Player 1's move in his small board.");
        animImageView.setBackgroundResource(R.drawable.anim2);
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
