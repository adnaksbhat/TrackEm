package com.example.trackem;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ThisBarChart extends AppCompatActivity {


    BarChart BarChart;
    ArrayList<BarEntry> barEntryArrayList;
    ArrayList<String> labelsName;
    ArrayList<MonthDatesData> monthDatesDataArrayList=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);


        BarChart =findViewById(R.id.barChart);

barEntryArrayList=new ArrayList<>();
labelsName=new ArrayList<>();

//barEntryArrayList.clear();
//labelsName.clear();

        fillMonthSales();   //call method
    for (int i = 0;i<monthDatesDataArrayList.size();i++){
    String month=monthDatesDataArrayList.get(i).getMonth();
    int sales=monthDatesDataArrayList.get(i).getSales();

    barEntryArrayList.add(new BarEntry(i,sales));
    labelsName.add(month);

}


        BarDataSet barDataSet=new BarDataSet(barEntryArrayList,"Monthly Sales");
    barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        Description description=new Description();
        description.setText("Months");
        BarChart.setDescription(description);
        BarData barData=new BarData(barDataSet);
        BarChart.setData(barData);

        XAxis xAxis= BarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labelsName));
        xAxis.setPosition(XAxis.XAxisPosition.TOP);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(labelsName.size());
        xAxis.setLabelRotationAngle(270);
        BarChart.animateY(2000);
        BarChart.invalidate();


    }


    private void fillMonthSales(){
        monthDatesDataArrayList.clear();
        monthDatesDataArrayList.add(new MonthDatesData("January",20000));
        monthDatesDataArrayList.add(new MonthDatesData("February",300));
        monthDatesDataArrayList.add(new MonthDatesData("March",200));
        monthDatesDataArrayList.add(new MonthDatesData("April",1000));
        monthDatesDataArrayList.add(new MonthDatesData("May",100));
        monthDatesDataArrayList.add(new MonthDatesData("June",20));
        monthDatesDataArrayList.add(new MonthDatesData("July",3500));
        monthDatesDataArrayList.add(new MonthDatesData("August",20000));
        monthDatesDataArrayList.add(new MonthDatesData("September",2900));
        monthDatesDataArrayList.add(new MonthDatesData("October",200));
        monthDatesDataArrayList.add(new MonthDatesData("November",900));
        monthDatesDataArrayList.add(new MonthDatesData("December",7000));

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


            Intent intent = new Intent(ThisBarChart.this, HomeActivity.class);
            startActivity(intent);
            finish();


        }



        return super.onOptionsItemSelected(item);
    }



}
