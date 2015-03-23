package com.hcjcch.ownui;

import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.hcjcch.ownui.ui.CircleImageDrawable;
import com.hcjcch.ownui.ui.RoundImageDrawable;


public class MainActivity extends ActionBarActivity {

    private ImageView imageView;
    private ImageView roundImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        roundImageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setImageDrawable(new CircleImageDrawable(BitmapFactory.decodeResource(getResources(), R.mipmap.huangchen)));
        roundImageView.setImageDrawable(new RoundImageDrawable(BitmapFactory.decodeResource(getResources(), R.mipmap.huangchen), 90));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
