package com.example.basicgrid;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class screenview1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.tutorial, container, false);
        /*Button b = (Button) rootView.findViewById(R.id.prev);
        b.setVisibility(-1);
        Button b1 = (Button) rootView.findViewById(R.id.next);
        b1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 
			     
			}});*/
        final ImageView animImageView = (ImageView) rootView.findViewById(R.id.ivAnimation);
        final TextView tv = (TextView)rootView.findViewById(R.id.text_vp);
        animImageView.setBackgroundResource(R.drawable.anim);
        tv.setText("The game has 9 small Tic Tac Toe-s which are played simultaneously.");
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
