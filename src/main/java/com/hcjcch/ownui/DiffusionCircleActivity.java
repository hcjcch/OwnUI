package com.hcjcch.ownui;

import android.app.Activity;
import android.os.Bundle;

import com.hcjcch.ownui.ui.DiffusionCircleView;

/**
 * Created by hcjcch on 2015/3/27.
 */

public class DiffusionCircleActivity extends Activity {

    private DiffusionCircleView diffusionCircleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diffusion_circle);
        diffusionCircleView = (DiffusionCircleView) findViewById(R.id.diffusionCircle);
        new Thread(diffusionCircleView).start();
    }
}