package com.example.trackem;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class tab1 extends Fragment {
ImageView plus1,imgwhy,xe,oc,sc,homi;



















    public tab1() {
        // Required empty public constructor

    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View rootView = inflater.inflate(R.layout.fragment_tab1, container, false);





        plus1=rootView.findViewById(R.id.plus1);
        plus1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent intent = new Intent (tab1.this.getActivity(), AddIncome.class);
                tab1.this.getActivity().startActivity(intent);
            }
        });

        imgwhy=rootView.findViewById(R.id.imgwhy);
        imgwhy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii=new Intent(tab1.this.getActivity(),ShowData.class);
                tab1.this.getActivity().startActivity(ii);
            }
        });


        xe=rootView.findViewById(R.id.xe);
        xe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.xe.com/currencyconverter/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        oc=rootView.findViewById(R.id.oc);
        oc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www1.oanda.com/currency/converter/");
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);
            }
        });

        sc=rootView.findViewById(R.id.sc);
        sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iii=new Intent(tab1.this.getActivity(),Convertor.class);
                startActivity(iii);

            }
        });


        homi=rootView.findViewById(R.id.homi);
        homi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iii=new Intent(tab1.this.getActivity(),HomeActivity.class);
                startActivity(iii);

            }
        });









        return rootView;













    }
    //below for retrieving data from firebase


}


