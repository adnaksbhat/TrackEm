package com.example.trackem;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowData extends AppCompatActivity {
    DatabaseReference dbartist;

    ListView listViewArtists;
    List<Member> memberList;

    FirebaseUser user;
    String uid;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
FirebaseAuth mFirebaseAuth;
FirebaseDatabase mFirebaseDatabase;

//ImageView buttonDelete;

//    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

dbartist= FirebaseDatabase.getInstance().getReference("Member");

               listViewArtists=findViewById(R.id.listViewArtists);
                    memberList=new ArrayList<>();
    }


    @Override
    protected void onStart() {
        super.onStart();
        dbartist.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                memberList.clear();
                for(DataSnapshot artistSnapshot : dataSnapshot.getChildren()){
                    Member member=artistSnapshot.getValue(Member.class);
                    memberList.add(member);

                }


                ArtistList adapter =new ArtistList(ShowData.this,memberList);
                listViewArtists.setAdapter(adapter);

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


            Intent intent = new Intent(ShowData.this, Plate2.class);
            startActivity(intent);
            finish();


        }
        else if(id==R.id.home2){


            Intent intent = new Intent(ShowData.this, HomeActivity.class);
            startActivity(intent);
            finish();

        }



        return super.onOptionsItemSelected(item);
    }
}
