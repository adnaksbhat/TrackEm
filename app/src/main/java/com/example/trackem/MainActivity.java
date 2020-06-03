package com.example.trackem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    //todo login screen

    ImageView imageButton;


    EditText etemail,etpass,etname;
    ImageView blogin;
    TextView tregister;
    FirebaseAuth mFirebaseAuth;                                                                      //1

    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        addListenerOnButton();


//        Intent i = new Intent(MainActivity.this, AddIncome.class);


        mFirebaseAuth=FirebaseAuth.getInstance();                                                     //2
        etemail=findViewById(R.id.etemail);
        etpass=findViewById(R.id.etpass);
        etname=findViewById(R.id.etname);
        blogin=findViewById(R.id.blogin);
        tregister=findViewById(R.id.tregister);

//note::  here login is register button and vice versa

        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=etemail.getText().toString();
                String pwd=etpass.getText().toString();
                String nm=etname.getText().toString();

                Intent intent = new Intent(MainActivity.this, AddIncome.class);
                st=etname.getText().toString();
                intent.putExtra("Key",st);



                if(email.isEmpty()) {
                    etemail.setError("Please enter Email Id");
                    etemail.requestFocus();
                }
                    else if(pwd.isEmpty()){
                        etpass.setError("Please enter your Password");
                        etpass.requestFocus();

                }
                else if(nm.isEmpty()){
                    etname.setError("Please enter your UserName");
                    etname.requestFocus();

                }
                    else if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                    else if(!(email.isEmpty() && pwd.isEmpty())){
                        mFirebaseAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()){
                                    Toast.makeText(MainActivity.this, "Unsuccesfull", Toast.LENGTH_SHORT).show();
                            }
                            else

                            {

                                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                startActivity(intent);
                            }
                        }

                        });
                }
                    else {
                    Toast.makeText(MainActivity.this, "Error Occured!!", Toast.LENGTH_SHORT).show();
                }


            }
        });





        //for registering

        tregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Register.class);
                startActivity(i);

            }
        });









    }

    //for button hover colors
    public void addListenerOnButton() {

        imageButton =  findViewById(R.id.blogin);

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                //Toast.makeText(MyAndroidAppActivity.this,"ImageButton (selector) is clicked!",Toast.LENGTH_SHORT).show();

            }

        });

    }












}

