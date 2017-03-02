package com.example.saklain.child;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by saklain on 3/2/17.
 */

public class ChildrenGrowth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ch_growth);
        Button btn32 = (Button)findViewById(R.id.btn32);
        btn32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"HUDAI PRINT", Toast.LENGTH_SHORT).show();
                Intent in2 = new Intent(ChildrenGrowth.this, GrowthSteps.class);
                startActivity(in2);
            }
        });
    }
}