package com.example.basicgrid;


import java.util.ArrayList;
import java.util.List;

import net.simonvt.menudrawer.MenuDrawer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class BaseActivity extends Activity {
	public MenuDrawer mMenuDrawer;	
	ListView lv;
	SlidingNavAdapter adapter;
	List<SlidingGetSet>items;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setUpMenu();
		setUpMainView();
		initNavView();
		setUpSlidingItems();
		clickAction();
	}
	
	void setUpMenu(){
		mMenuDrawer = MenuDrawer.attach(this, MenuDrawer.MENU_DRAG_CONTENT);
        mMenuDrawer.setOffsetMenuEnabled(false);
        //mMenuDrawer.setDropShadow(R.color.transparent);
	}
	void initNavView(){
		lv=(ListView)findViewById(R.id.navList);
	}
	void setUpSlidingItems(){
		items = new ArrayList<SlidingGetSet>();
		items.add(new SlidingGetSet("New Game"));
		items.add(new SlidingGetSet("Tutorial"));
		items.add(new SlidingGetSet("Settings"));
		items.add(new SlidingGetSet("Exit"));
		adapter=new SlidingNavAdapter(items,this);
		lv.setAdapter(adapter);
	}
	public void enableMenu(){
		mMenuDrawer.setEnabled(true);
	}
	public void disableMenu(){
		mMenuDrawer.setEnabled(false);
	}
	void setUpMainView(){
		mMenuDrawer.setMenuView(R.layout.sliding_layout);
	  
	}
	
	@Override
    public void setContentView(int layoutResID) {
        // This override is only needed when using MENU_DRAG_CONTENT.
		mMenuDrawer.setContentView(layoutResID);
		onContentChanged();
    }
	
	@Override
    public void onBackPressed() {
        final int drawerState = mMenuDrawer.getDrawerState();
        if (drawerState == MenuDrawer.STATE_OPEN || drawerState == MenuDrawer.STATE_OPENING) {
            mMenuDrawer.closeMenu();
            return;
        }
        super.onBackPressed();
    }
	
	
	void clickAction(){
		 lv.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				// TODO Auto-generated method stub
				menuClickAction(pos);
				mMenuDrawer.closeMenu();
			}
		 });
	}
	void menuClickAction(int pos){
		final int ONE       = 0;
		final int TWO       = 1;
		final int THREE     = 2;
		final int FOUR      = 3;
		switch(pos){
		case ONE:
			Toast.makeText(this, "One", Toast.LENGTH_SHORT).show();
			break;
		case TWO:
			Toast.makeText(this, "Two", Toast.LENGTH_SHORT).show();
			Intent tutorial = new Intent(this, ScreenSlideActivity.class);
			startActivity(tutorial);
			break;
		case THREE:
			Toast.makeText(this, "Three", Toast.LENGTH_SHORT).show();
			break;
		case FOUR:
			Toast.makeText(this, "Four", Toast.LENGTH_SHORT).show();
			break;
		}
	}

	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
