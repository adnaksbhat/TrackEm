package com.example.trackem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {


    private int nooftabs;











    //the below 3 methods are created while pressing alt enter while writing line 8.

    public PageAdapter(@NonNull FragmentManager fm , int noofTabs) {
        super(fm);
        this.nooftabs=noofTabs;
    }




    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new tab1();
            case 1:
                return new tab2();
            default:
                return null;

        }
    }




    @Override
    public int getCount() {
        return nooftabs;
    }

    //this below is created by u only...
    @Override
    public int getItemPosition(@NonNull  Object object){
        return POSITION_NONE;
    }


}
