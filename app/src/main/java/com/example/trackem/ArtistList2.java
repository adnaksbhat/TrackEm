package com.example.trackem;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ArtistList2 extends ArrayAdapter<Member2> {

    private Activity context;
    private List<Member2> memberList2;

    public ArtistList2(Activity context, List<Member2> memberList2){
        super(context,R.layout.templete2,memberList2);
        this.context=context;
        this.memberList2=memberList2;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem2=inflater.inflate(R.layout.templete2,null,true);

        TextView mugtv1=listViewItem2.findViewById(R.id.mmugtv1);
        TextView mugtv2=listViewItem2.findViewById(R.id.mmugtv2);
        TextView mugtv3=listViewItem2.findViewById(R.id.mmugtv3);
        TextView mugtv4=listViewItem2.findViewById(R.id.mmugtv4);
        TextView mugtv5=listViewItem2.findViewById(R.id.mmugtv5);


        Member2 member2=memberList2.get(position);

        mugtv1.setText(member2.getDate2());
        mugtv2.setText(member2.getAccount2());
        mugtv3.setText(member2.getCategory2());
        mugtv4.setText("₹ "+member2.getAmount2());
        mugtv5.setText(member2.getContent2());

        return listViewItem2;

    }
}
