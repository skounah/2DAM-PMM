package com.misfigurasaleatorias.victor.misfigurasaleatorias;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class Pantalla1 extends ActionBarActivity {
    private RandomShapeView mDrawingArea;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);
        mDrawingArea = (RandomShapeView) findViewById(R.id.drawing_area);
    }

    // Handles events for the button. Redraws the ShapeView.
    public void redraw(View clickedButton) {
        clickedButton.invalidate();
        //mDrawingArea.onDraw(findViewById(R.id.drawing_area));
    }
}
