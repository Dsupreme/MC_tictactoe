package com.example.basicgrid;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class screenview4 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.tutorial, container, false);
        
        final ImageView animImageView = (ImageView) rootView.findViewById(R.id.ivAnimation);
        animImageView.setBackgroundResource(R.drawable.anim4);
        final TextView tv4 = (TextView)rootView.findViewById(R.id.text_vp);
        tv4.setText("First one to win 3 mini boards in a row wins the game.");
        
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
