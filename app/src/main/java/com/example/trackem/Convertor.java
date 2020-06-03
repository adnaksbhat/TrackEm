package com.example.trackem;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Convertor extends AppCompatActivity {

    ImageView rsd,rse,rsdi,rsy;
    EditText rs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertor);

        rs=findViewById(R.id.rs);


        rsd=findViewById(R.id.rsd);
        rse=findViewById(R.id.rse);
        rsdi=findViewById(R.id.rsdi);
        rsy=findViewById(R.id.rsy);




        rsd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double rsamt=Double.parseDouble(rs.getText().toString());
                Double dolloramt=rsamt * 0.013;
                Toast.makeText(Convertor.this, "$ " + dolloramt.toString(), Toast.LENGTH_LONG).show();
            }
        });
        rse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double rsamt2=Double.parseDouble(rs.getText().toString());
                Double euroamt=rsamt2 * 0.012;
                Toast.makeText(Convertor.this, "€ " + euroamt.toString(), Toast.LENGTH_LONG).show();
            }
        });
        rsdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double rsamt3=Double.parseDouble(rs.getText().toString());
                Double diramamt=rsamt3 * 0.048;
                Toast.makeText(Convertor.this, " د.إ" +  diramamt.toString(), Toast.LENGTH_LONG).show();
            }
        });
        rsy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double rsamt4=Double.parseDouble(rs.getText().toString());
                Double yenamt=rsamt4 * 0.093;
                Toast.makeText(Convertor.this, "¥ " + yenamt.toString(), Toast.LENGTH_LONG).show();
            }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu3, menu);
//        getMenuInflater().inflate(R.menu.drawermenu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();



        if (id==R.id.back3){
            Intent intent = new Intent(Convertor.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }



        return super.onOptionsItemSelected(item);
    }






}
