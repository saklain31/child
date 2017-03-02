package com.example.saklain.child;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PregnancyTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregnancy_time);
        Button btn11= (Button)findViewById(R.id.btn11);
        Button btn12= (Button)findViewById(R.id.btn12);
        Button btn13= (Button)findViewById(R.id.btn13);
        Button btn14= (Button)findViewById(R.id.btn14);
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PregnancyTime.this,"HUDAI PRINT", Toast.LENGTH_SHORT).show();

            }
        });

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PregnancyTime.this,"HUDAI PRINT", Toast.LENGTH_SHORT).show();
                Intent in2 = new Intent(PregnancyTime.this, ChildrenGrowth.class);
                startActivity(in2);
            }
        });
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PregnancyTime.this,"HUDAI PRINT", Toast.LENGTH_SHORT).show();
                Intent in3 = new Intent(PregnancyTime.this, Education.class);
                startActivity(in3);
            }
        });
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PregnancyTime.this,"HUDAI PRINT", Toast.LENGTH_SHORT).show();
                Intent in4 = new Intent(PregnancyTime.this, HelpLine.class);
                startActivity(in4);
            }
        });

    }
}
