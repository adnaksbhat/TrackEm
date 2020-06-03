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
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {




String st;


    EditText etemailreg,etpassreg;
    ImageView bregister;
    TextView tlogin;
    FirebaseAuth mFirebaseAuth;

    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth=FirebaseAuth.getInstance();
        etemailreg=findViewById(R.id.etemailreg);
        etpassreg=findViewById(R.id.etpassreg);
        bregister=findViewById(R.id.bregister);
        tlogin=findViewById(R.id.tlogin);



        mAuthStateListener=new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser=mFirebaseAuth.getCurrentUser();
                if(mFirebaseUser!=null){
                    Toast.makeText(Register.this, "Logged in Succesfully", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Register.this,HomeActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(Register.this, "Please Login", Toast.LENGTH_SHORT).show();
                }

            }
        };

        bregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=etemailreg.getText().toString();
                String pwd=etpassreg.getText().toString();
                if(email.isEmpty()) {
                    etemailreg.setError("Please enter Email Id");
                    etemailreg.requestFocus();
                }
                else if(pwd.isEmpty()){
                    etpassreg.setError("Please enter your Password");
                    etpassreg.requestFocus();

                }
                else if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(Register.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else if(!(email.isEmpty() && pwd.isEmpty())){
                   mFirebaseAuth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if(!task.isSuccessful()){
                               Toast.makeText(Register.this, "Error", Toast.LENGTH_SHORT).show();
                           }
                           else {
                               Intent intent=new Intent(Register.this,HomeActivity.class);
                               startActivity(intent);
                           }
                       }
                   });
                }
                else {
                    Toast.makeText(Register.this, "Error Occured!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iii=new Intent(Register.this,MainActivity.class);
                startActivity(iii);

            }
        });




    }





    protected void onStart(){
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }




}
