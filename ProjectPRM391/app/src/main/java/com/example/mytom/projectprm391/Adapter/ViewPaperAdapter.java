package com.example.mytom.projectprm391.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.mytom.projectprm391.Fragments.AddExam;
import com.example.mytom.projectprm391.Fragments.Exam;
import com.example.mytom.projectprm391.Fragments.History;
import com.example.mytom.projectprm391.Fragments.Session;

import java.util.ArrayList;

/**
 * Created by Mytom on 3/7/2017.
 */

public class ViewPaperAdapter extends FragmentStatePagerAdapter {
    int tabCount;
    ArrayList<Fragment> fragments = new ArrayList<>();
    public ViewPaperAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Exam tab1 = new Exam();

                return tab1;
            case 1:
                History tab2 = new History();
                return tab2;
            case 2:
                Session tab3 = new Session();
                return tab3;
            case 3:
                AddExam tab4 = new AddExam();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

}
