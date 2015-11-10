package com.tiposllamadaseventos.victor.tiposllamadaseventos;

import android.app.Activity;
        import android.content.Context;
        import android.os.Bundle;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.Toast;

public class MainActivity extends Activity {
    Context ctx=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //LA LLAMADA DESDE LA CLASE MiButton se hace al crear el objeto en el XML
        super.onCreate(savedInstanceState);
        ctx=this;
        setContentView(R.layout.activity_main);

        //LAMADA CLASICA
        Button btn=(Button)this.findViewById(R.id.button3);
        btn.setOnClickListener(new OnClickListener(){
             public void onClick(View v) {
                   Toast.makeText(ctx, "Pulsado boton Tres", Toast.LENGTH_SHORT).show();
             }
        });
    }
            //LLMADA DESDE EL XML
            public void button2_click(View v){
                Toast.makeText(this, "Pulsado boton Dos", Toast.LENGTH_SHORT).show();
            }
}