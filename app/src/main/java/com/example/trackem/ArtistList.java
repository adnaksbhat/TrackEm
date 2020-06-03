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

public class ArtistList extends ArrayAdapter<Member> {

    private Activity context;
    private List<Member> memberList;

    public ArtistList(Activity context, List<Member> memberList){
        super(context,R.layout.templete,memberList);
        this.context=context;
        this.memberList=memberList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.templete,null,true);

        TextView mugtv1=listViewItem.findViewById(R.id.mugtv1);
        TextView mugtv2=listViewItem.findViewById(R.id.mugtv2);
        TextView mugtv3=listViewItem.findViewById(R.id.mugtv3);
        TextView mugtv4=listViewItem.findViewById(R.id.mugtv4);
        TextView mugtv5=listViewItem.findViewById(R.id.mugtv5);


        Member member=memberList.get(position);

        mugtv1.setText(member.getDate());
        mugtv2.setText(member.getAccount());
        mugtv3.setText(member.getCategory());
        mugtv4.setText("₹ "+member.getAmount());
        mugtv5.setText(member.getContent());

return listViewItem;

    }
}
