package com.example.trackem;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class AddExpense extends AppCompatActivity {
    private EditText etdate2,etamt2,etcontent2;
    ImageView imgcancel2,imgsave2;
    private DatePickerDialog.OnDateSetListener mDataSetListener2;

    Spinner spinnercat2,spinneracc2;
    ArrayAdapter<CharSequence> adapter1,adapter2;




    DatabaseReference reff2;
    Member2 member2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        member2=new Member2();
        reff2= FirebaseDatabase.getInstance().getReference().child("Member2");



        etdate2=  findViewById(R.id.etdate2);
        etamt2=findViewById(R.id.etamt2);
        etcontent2=findViewById(R.id.etcontent2);
        spinneracc2=findViewById(R.id.spinneracc2);
        spinnercat2=findViewById(R.id.spinnercat2);
imgsave2=findViewById(R.id.imgsave2);
        imgsave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                member2.setDate2(etdate2.getText().toString());
                member2.setAccount2(spinneracc2.getSelectedItem().toString());
                member2.setCategory2(spinnercat2.getSelectedItem().toString());
                member2.setAmount2(etamt2.getText().toString());
                member2.setContent2(etcontent2.getText().toString());

                String id2=reff2.push().getKey();
                reff2.child(id2).setValue(member2);
                Toast.makeText(AddExpense.this, "Inserted Succesfully", Toast.LENGTH_SHORT).show();
                Intent innn=new Intent(AddExpense.this,HomeActivity.class);
                startActivity(innn);


            }
        });





        imgcancel2=findViewById(R.id.imgcancel2);
        imgcancel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AddExpense.this,HomeActivity.class);
                startActivity(i);
                Toast.makeText(AddExpense.this, "Submission Canceled", Toast.LENGTH_SHORT).show();
            }
        });


        //below for spinner

        spinnercat2=findViewById(R.id.spinnercat2);
        adapter1= ArrayAdapter.createFromResource(this,R.array.categoryExp,android.R.layout.simple_spinner_item); //this layout is inbuilt
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnercat2.setAdapter(adapter1);

        //note:.. below onClick is different
        spinnercat2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

                Toast.makeText(getBaseContext(),parent.getItemAtPosition(i)+" selected" ,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinneracc2=findViewById(R.id.spinneracc2);
        adapter2= ArrayAdapter.createFromResource(this,R.array.account,android.R.layout.simple_spinner_item); //this layout is inbuilt
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinneracc2.setAdapter(adapter2);

        //note:.. below onClick is different
        spinneracc2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

                Toast.makeText(getBaseContext(),parent.getItemAtPosition(i)+" Selected" ,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });









//below for date picker
        etdate2=  findViewById(R.id.etdate2);
        etdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog dialog=new DatePickerDialog(AddExpense.this,    android.R.style.Theme_Holo_Light_Dialog_MinWidth,    mDataSetListener2,    year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDataSetListener2=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;   //coz in android january is 0 and december is 1
                String date=day + "/" + month +"/" + year;
                etdate2.setText(date);

            }
        };





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu2, menu);
//        getMenuInflater().inflate(R.menu.drawermenu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();



        if (id==R.id.back2){


            Intent intent = new Intent(AddExpense.this, Plate2.class);
            startActivity(intent);
finish();

        }
        else if(id==R.id.home2){


            Intent intent = new Intent(AddExpense.this, HomeActivity.class);
            startActivity(intent);
finish();
        }



        return super.onOptionsItemSelected(item);
    }



}
