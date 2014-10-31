package com.example.basicgrid;

import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends BaseActivity{	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            mMenuDrawer.toggleMenu();
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}
