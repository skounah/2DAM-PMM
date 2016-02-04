package com.misfigurasaleatorias.victor.misfigurasaleatorias;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchDrawShapes1(View clickedButton) {
        Intent activityIntent = new Intent(this, Pantalla1.class);
        startActivity(activityIntent);
    }

    public void launchDrawShapes2(View clickedButton) {
        Intent activityIntent = new Intent(this, Pantalla2.class);
        startActivity(activityIntent);
    }
    public void launchDrawShapes3(View clickedButton) {
        Intent activityIntent = new Intent(this, Pantalla3.class);
        startActivity(activityIntent);
    }

}
