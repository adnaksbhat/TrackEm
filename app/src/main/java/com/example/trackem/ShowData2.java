package com.example.trackem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowData2 extends AppCompatActivity {
    DatabaseReference dbartist2;

    ListView listViewArtists2;
    List<Member2> memberList2;


    private RecyclerView mRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data2);


        dbartist2= FirebaseDatabase.getInstance().getReference("Member2");

        listViewArtists2=findViewById(R.id.listViewArtists2);
        memberList2=new ArrayList<>();

    }


    @Override
    protected void onStart() {
        super.onStart();
        dbartist2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                memberList2.clear();
                for(DataSnapshot artistSnapshot : dataSnapshot.getChildren()){
                    Member2 member2=artistSnapshot.getValue(Member2.class);
                    memberList2.add(member2);

                }
                ArtistList2 adapter =new ArtistList2(ShowData2.this,memberList2);
                listViewArtists2.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


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


            Intent intent = new Intent(ShowData2.this, Plate2.class);
            startActivity(intent);
            finish();


        }
        else if(id==R.id.home2){


            Intent intent = new Intent(ShowData2.this, HomeActivity.class);
            startActivity(intent);
            finish();

        }



        return super.onOptionsItemSelected(item);
    }


}
