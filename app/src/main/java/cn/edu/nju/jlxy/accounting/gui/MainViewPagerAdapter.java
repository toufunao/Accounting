package cn.edu.nju.jlxy.accounting.gui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.ListView;
import cn.edu.nju.jlxy.accounting.gui.MainFragment;

import java.util.LinkedList;
import java.util.List;

/**
 * @author WuRJ
 * @Description
 * @time 2018-12-18 20:28
 */
public class MainViewPagerAdapter extends FragmentPagerAdapter {

    List<MainFragment> fragments=new LinkedList<>();
    List<String> dates=new LinkedList<>();

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragments();
    }


    private void initFragments(){
        dates.add("2017-06-01");
        dates.add("2017-06-02");
        dates.add("2017-06-03");
        for (String date:dates){
            MainFragment fragment=new MainFragment(date);
            System.out.println(date);
            fragments.add(fragment);
        }
    }


    public int getLastIndex(){
        return fragments.size()-1;
    }
    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
