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
public class tab2 extends Fragment {

    ImageView plus2,imgwhy2,xe,oc,sc,homi2;






    public tab2() {
        // Required empty public constructor
    }







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View rootView = inflater.inflate(R.layout.fragment_tab2, container, false);

        plus2=rootView.findViewById(R.id.plus2);
        plus2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent intent = new Intent (tab2.this.getActivity(), AddExpense.class);
                tab2.this.getActivity().startActivity(intent);
            }
        });


        imgwhy2=rootView.findViewById(R.id.imgwhy2);
        imgwhy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii=new Intent(tab2.this.getActivity(),ShowData2.class);
                tab2.this.getActivity().startActivity(ii);
            }
        });


        xe=rootView.findViewById(R.id.xe2);
        xe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.xe.com/currencyconverter/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        oc=rootView.findViewById(R.id.oc2);
        oc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www1.oanda.com/currency/converter/");
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);
            }
        });

        sc=rootView.findViewById(R.id.sc2);
        sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iii=new Intent(tab2.this.getActivity(),Convertor.class);
                startActivity(iii);

            }
        });



        homi2=rootView.findViewById(R.id.homi2);
        homi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iii=new Intent(tab2.this.getActivity(),HomeActivity.class);
                startActivity(iii);

            }
        });






        return rootView;




    }

}
