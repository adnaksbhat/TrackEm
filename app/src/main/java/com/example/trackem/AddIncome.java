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

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class AddIncome extends AppCompatActivity {
    int PLACE_PICKER_REQUEST=1;
    private EditText ename, etdate,get_place,etamt,etcontent;
    ImageView imgcancel,imgsave;
    private DatePickerDialog.OnDateSetListener mDataSetListener;

    Spinner spinnercat,spinneracc;
    ArrayAdapter<CharSequence> adapter1,adapter2;


    DatabaseReference reff,ereff;
    Member member;
//    MemEmail em;

//String result;
//    private AddIncome mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);

        member=new Member();
//        em=new MemEmail();




        reff= FirebaseDatabase.getInstance().getReference().child("Member");




        etdate=  findViewById(R.id.etdate);
        etamt=findViewById(R.id.etamt);
        etcontent=findViewById(R.id.etcontent);
        spinneracc=findViewById(R.id.spinneracc);
        spinnercat=findViewById(R.id.spinnercat);
        imgsave=findViewById(R.id.imgsave);
        ename=findViewById(R.id.ename);


//        Intent intent = getIntent();
//          result = intent.getStringExtra("Key");




        imgsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                member.setDate(etdate.getText().toString());
                member.setAccount(spinneracc.getSelectedItem().toString());
                member.setCategory(spinnercat.getSelectedItem().toString());
                member.setAmount(etamt.getText().toString());
                member.setContent(etcontent.getText().toString());
                member.setName(ename.getText().toString());
//                em.setName(result);

                String id=reff.push().getKey();
//                qemail=ee.getText().toString();
//                ereff=reff.child(qemail);
                reff.child(member.getName()).child(id).setValue(member);
                Toast.makeText(AddIncome.this, "Inserted Succesfully", Toast.LENGTH_SHORT).show();
                Intent innn=new Intent(AddIncome.this,HomeActivity.class);
                startActivity(innn);


            }
        });





        imgcancel=findViewById(R.id.imgcancel);
        imgcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AddIncome.this,HomeActivity.class);
                startActivity(i);
                Toast.makeText(AddIncome.this, "Submission Canceled", Toast.LENGTH_SHORT).show();
            }
        });


        //below for spinner

        spinnercat=findViewById(R.id.spinnercat);
        adapter1= ArrayAdapter.createFromResource(this,R.array.categoryInc,android.R.layout.simple_spinner_item); //this layout is inbuilt
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnercat.setAdapter(adapter1);

        //note:.. below onClick is different
        spinnercat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

                Toast.makeText(getBaseContext(),parent.getItemAtPosition(i)+" selected" ,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinneracc=findViewById(R.id.spinneracc);
        adapter2= ArrayAdapter.createFromResource(this,R.array.account,android.R.layout.simple_spinner_item); //this layout is inbuilt
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinneracc.setAdapter(adapter2);

        //note:.. below onClick is different
        spinneracc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

                Toast.makeText(getBaseContext(),parent.getItemAtPosition(i)+" Selected" ,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });









//below for date picker

         etdate.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Calendar cal=Calendar.getInstance();
                 int year=cal.get(Calendar.YEAR);
                 int month=cal.get(Calendar.MONTH);
                 int day=cal.get(Calendar.DAY_OF_MONTH);


                 DatePickerDialog dialog=new DatePickerDialog(AddIncome.this,    android.R.style.Theme_Holo_Light_Dialog_MinWidth,    mDataSetListener,    year,month,day);
                 dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                 dialog.show();
             }
         });

         mDataSetListener=new DatePickerDialog.OnDateSetListener() {
             @Override
             public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                 month=month+1;   //coz in android january is 0 and december is 1
                 String date=day + "/" + month +"/" + year;
                 etdate.setText(date);

             }
         };





    }










    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode==PLACE_PICKER_REQUEST)
        {
            if(resultCode==RESULT_OK)
            {
                Place place=PlacePicker.getPlace(data,this);
                String address=String.format("Place is : %s",place.getAddress());
                get_place.setText(address);
            }
        }
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


            Intent intent = new Intent(AddIncome.this, Plate2.class);
            startActivity(intent);
            finish();


        }
        else if(id==R.id.home2){


            Intent intent = new Intent(AddIncome.this, HomeActivity.class);
            startActivity(intent);
            finish();

        }

       

        return super.onOptionsItemSelected(item);
    }



}
