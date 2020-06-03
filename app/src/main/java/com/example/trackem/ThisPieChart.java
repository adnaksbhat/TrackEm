package com.example.trackem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThisPieChart extends AppCompatActivity {

//    DatabaseReference dbartist;


//    List<Member> memberList;



    PieChart pieChart,pieChart2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);





//        dbartist= FirebaseDatabase.getInstance().getReference("Member");


//        memberList=new ArrayList<>();



        pieChart =  findViewById(R.id.pieChart);
//
                pieChart.setUsePercentValues(false);
                pieChart.getDescription().setEnabled(false);
                pieChart.setExtraOffsets(5, 10, 5, 5);
                pieChart.setDragDecelerationFrictionCoef(0.95f);
                pieChart.setDrawHoleEnabled(true);
                pieChart.setHoleColor(Color.WHITE);
                pieChart.setHoleRadius(15f);
                pieChart.setTransparentCircleRadius(25f);

                ArrayList<PieEntry> yValues = new ArrayList<>();


        yValues.add(new PieEntry(13f,"Cash"));
        yValues.add(new PieEntry(23f,"Card"));
        yValues.add(new PieEntry(50f,"Accounts"));
        yValues.add(new PieEntry(14f,"Loan"));
        yValues.add(new PieEntry(30f,"Wallet"));


        PieDataSet dataSet = new PieDataSet(yValues, "Income PieChart");
//
                    dataSet.setSliceSpace(3f);
                    dataSet.setSelectionShift(5f);
                    dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                    PieData data = new PieData(dataSet);
                    data.setValueTextSize(10f);
                    data.setValueTextColor(Color.TRANSPARENT);
                    pieChart.setData(data);







        //2nd pie chart
        pieChart2=findViewById(R.id.pieChart2);

        pieChart2.setUsePercentValues(true);
        pieChart2.getDescription().setEnabled(false);
        pieChart2.setExtraOffsets(5,10,5,5);
        pieChart2.setDragDecelerationFrictionCoef(0.95f);
        pieChart2.setDrawHoleEnabled(true);
        pieChart2.setHoleColor(Color.WHITE);
        pieChart2.setHoleRadius(15f);
        pieChart2.setTransparentCircleRadius(25f);


        ArrayList<PieEntry> yValues2=new ArrayList<>();

        yValues2.add(new PieEntry(30f,"Cash"));
        yValues2.add(new PieEntry(13f,"Card"));
        yValues2.add(new PieEntry(20f,"Accounts"));
        yValues2.add(new PieEntry(22f,"Loan"));
        yValues2.add(new PieEntry(30f,"Wallet"));




        PieDataSet dataSet2=new PieDataSet(yValues2,"Expense PieChart");

        dataSet2.setSliceSpace(3f);
        dataSet2.setSelectionShift(5f);
        dataSet2.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data2=new PieData(dataSet2);
        data2.setValueTextSize(10f);
        data2.setValueTextColor(Color.YELLOW);
        pieChart2.setData(data2);



    }



//    @Override
//    protected void onStart() {
//        super.onStart();
//        dbartist.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                pieChart = (PieChart) findViewById(R.id.pieChart);
//
//                pieChart.setUsePercentValues(false);
//                pieChart.getDescription().setEnabled(false);
//                pieChart.setExtraOffsets(5, 10, 5, 5);
//                pieChart.setDragDecelerationFrictionCoef(0.95f);
//                pieChart.setDrawHoleEnabled(true);
//                pieChart.setHoleColor(Color.WHITE);
//                pieChart.setHoleRadius(15f);
//                pieChart.setTransparentCircleRadius(25f);
//
//                ArrayList<PieEntry> yValues = new ArrayList<>();
//
//
//                pieChart2 = findViewById(R.id.pieChart2);
//
//                pieChart2.setUsePercentValues(false);
//                pieChart2.getDescription().setEnabled(false);
//                pieChart2.setExtraOffsets(5, 10, 5, 5);
//                pieChart2.setDragDecelerationFrictionCoef(0.95f);
//                pieChart2.setDrawHoleEnabled(true);
//                pieChart2.setHoleColor(Color.WHITE);
//                pieChart2.setHoleRadius(15f);
//                pieChart2.setTransparentCircleRadius(25f);
//
//
//                ArrayList<PieEntry> yValues2 = new ArrayList<>();
//
//
//                yValues.clear();
//                yValues2.clear();
////                if(dataSnapshot.exists())
//                for (DataSnapshot artistSnapshot : dataSnapshot.getChildren()) {
//                    Member member = artistSnapshot.getValue(Member.class);
//
//
//                    yValues.add(new PieEntry(1f, member.getCategory()));
//
//
//                    PieDataSet dataSet = new PieDataSet(yValues, "Income PieChart");
//
//                    dataSet.setSliceSpace(3f);
//                    dataSet.setSelectionShift(5f);
//                    dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
//                    PieData data = new PieData(dataSet);
//                    data.setValueTextSize(10f);
//                    data.setValueTextColor(Color.TRANSPARENT);
//                    pieChart.setData(data);
//
//
//                }
//
//
//                for (DataSnapshot artistSnapshot2 : dataSnapshot.getChildren()) {
//
//                    Member2 member2 = artistSnapshot2.getValue(Member2.class);
//                    yValues2.add(new PieEntry(1f, member2.getCategory2()));
//
//
//                    PieDataSet dataSet2 = new PieDataSet(yValues2, "Expense PieChart");
//
//                    dataSet2.setSliceSpace(3f);
//                    dataSet2.setSelectionShift(5f);
//                    dataSet2.setColors(ColorTemplate.COLORFUL_COLORS);
//                    PieData data2 = new PieData(dataSet2);
//                    data2.setValueTextSize(10f);
//                    data2.setValueTextColor(Color.TRANSPARENT);
//                    pieChart2.setData(data2);
//
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//
//    }
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


            Intent intent = new Intent(ThisPieChart.this, HomeActivity.class);
            startActivity(intent);

finish();
        }



        return super.onOptionsItemSelected(item);
    }


}
