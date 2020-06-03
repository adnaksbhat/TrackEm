package com.example.trackem;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    ImageView img1;


    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    //the above 2 lines is for drawer navigation


    Button blogout;
    FirebaseAuth mFirebaseAuth;
    CardView card1,card4,card7,card5,card6,card2,card3;


    private FirebaseAuth.AuthStateListener mAuthStateListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);






        //the below is for drawer navigation
        mDrawerlayout=findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(this,mDrawerlayout,R.string.open,R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerview = navigationView.getHeaderView(0);


        img1 = headerview.findViewById(R.id.img1);


        ConstraintLayout header =headerview.findViewById(R.id.header);
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                img1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent ii=new Intent(HomeActivity.this,SelectImageActivity.class);
//                        startActivity(ii);
//
//                    }
//                });


            }
        });



        card1=findViewById(R.id.card1);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iqi=new Intent(HomeActivity.this,Plate2.class);
                startActivity(iqi);
            }
        });

        card4=findViewById(R.id.card4);
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iqi=new Intent(HomeActivity.this,Feedback.class);
                startActivity(iqi);
            }
        });
        card7=findViewById(R.id.card7);
        card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iqi=new Intent(HomeActivity.this,Convertor.class);
                startActivity(iqi);
            }
        });
        card5=findViewById(R.id.card5);
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iqi=new Intent(HomeActivity.this,ThisBarChart.class);
                startActivity(iqi);
                Toast.makeText(HomeActivity.this, "* These values are explicitly set by the Database handler based on the inserted info *", Toast.LENGTH_LONG).show();
            }
        });
        card6=findViewById(R.id.card6);
        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iqi=new Intent(HomeActivity.this,ThisPieChart.class);
                startActivity(iqi);
                Toast.makeText(HomeActivity.this, "* These values are explicitly set by the Database handler based on the inserted info *", Toast.LENGTH_LONG).show();
            }
        });

//        card2=findViewById(R.id.card2);
//        card2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent iqi=new Intent(HomeActivity.this,NotificationView.class);
//                startActivity(iqi);
//            }
//        });

        card3=findViewById(R.id.card3);
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iqi=new Intent(HomeActivity.this,Ratings.class);
                startActivity(iqi);
            }
        });






//
//        blogout=findViewById(R.id.blogout);
//        blogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FirebaseAuth.getInstance().signOut();
//                Intent intent=new Intent(HomeActivity.this,MainActivity.class);
//                startActivity(intent);
//            }
//        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
//        getMenuInflater().inflate(R.menu.drawermenu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mlogout) {
            Toast.makeText(this, "Logging Out", Toast.LENGTH_LONG).show();
            FirebaseAuth.getInstance().signOut();

            Intent intent = new Intent(HomeActivity.this, Register.class);
            startActivity(intent);



        }

        else if (id==R.id.db){
            Toast.makeText(this, "Back to dash", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
            startActivity(intent);


        }
        else if (id==R.id.back){
            Toast.makeText(this, "This is Home Page", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();


        }

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }





    //below for drawer menu




//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.mlogout) {
//            Toast.makeText(this, "Logging Out", Toast.LENGTH_LONG).show();
//            FirebaseAuth.getInstance().signOut();
//            Intent intent = new Intent(HomeActivity.this, Register.class);
//            startActivity(intent);
//
//        }
//        if(mToggle.onOptionsItemSelected(item)){
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//



}
