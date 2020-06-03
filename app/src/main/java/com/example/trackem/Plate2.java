package com.example.trackem;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;







public class Plate2 extends AppCompatActivity {

    //instructions for doing tabs.
    //go to plate2.xml and create a tablayout and inside it create how much tabitems u want.
    //outside tablayout create viewpager
    //then in plate2.java write down codes from line 31 till 87
    //then create PageAdapter java file
    //in tht extend to FragmentPagerAdapter and do  all those codes
    //then new->Fragment->Fragment(Blank)    like tht create 2     name it tab1 and tab2  (these names are same as switchcases in PageAdapter.java
    //done

ImageView plus1;

     TabLayout tablayout;
     TabItem tab1,tab2;
     ViewPager viewPager;
     PageAdapter pagerAdapter;     //note......> PageAdapter is function name in PageAdapter.java


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plate2);

        tablayout=findViewById(R.id.tablayout);
        tab1=findViewById(R.id.tab1);
        tab2=findViewById(R.id.tab2);
        viewPager=findViewById(R.id.viewPager);


        pagerAdapter=new PageAdapter(getSupportFragmentManager(),tablayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);



        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());


                if(tab.getPosition()==0) {
                    pagerAdapter.notifyDataSetChanged();
                }
                else if(tab.getPosition()==1) {
                    pagerAdapter.notifyDataSetChanged();
                }
               else if(tab.getPosition()==2) {
                    pagerAdapter.notifyDataSetChanged();
                }
            }




            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));


        //till above only for tabs..








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


            Intent intent = new Intent(Plate2.this, HomeActivity.class);
            startActivity(intent);
            finish();


        }



        return super.onOptionsItemSelected(item);
    }




    }

