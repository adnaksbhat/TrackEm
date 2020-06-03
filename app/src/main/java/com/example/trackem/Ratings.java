package com.example.trackem;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Ratings extends AppCompatActivity {


    DatabaseReference reff,reff1;
    RatingMember member;




    TextView oitext;
    Button viewrate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);

//        oitext=findViewById(R.id.oitext);
        viewrate=findViewById(R.id.viewrate);



        //below for inserting ratevalue
        member = new RatingMember();
        reff = FirebaseDatabase.getInstance().getReference().child("RatingMember");


        final RatingBar ratingRatinbar = findViewById(R.id.rating_ratingbar);
        Button submit_button = findViewById(R.id.submit_button);
        final TextView ttt = findViewById(R.id.ttt);

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float t = ratingRatinbar.getRating();
                ttt.setText("Your Rating is : " + ratingRatinbar.getRating()+ " ⭐");

                member.setRateus(t.toString());


//                String id=reff.push().getKey();
                reff.setValue(member);


            }
        });







//below for viewing rates




       viewrate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               reff1=FirebaseDatabase.getInstance().getReference().child("RatingMember");
               reff1.addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       String thestring=dataSnapshot.child("rateus").getValue().toString();
                       Toast.makeText(Ratings.this, "Previously rated "+thestring+" ⭐", Toast.LENGTH_SHORT).show();
//                       oitext.setText(thestring);

                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError databaseError) {

                   }
               });
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


            Intent intent = new Intent(Ratings.this, HomeActivity.class);
            startActivity(intent);
finish();

        }



        return super.onOptionsItemSelected(item);
    }






}
