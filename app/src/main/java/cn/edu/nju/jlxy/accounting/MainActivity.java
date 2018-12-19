package cn.edu.nju.jlxy.accounting;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import cn.edu.nju.jlxy.accounting.gui.MainViewPagerAdapter;
import cn.edu.nju.jlxy.accounting.util.GlobalUtil;
import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private MainViewPagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().setElevation(0);

        viewPager=(ViewPager)findViewById(R.id.view_Pager);
        pagerAdapter=new MainViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.notifyDataSetChanged();
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(pagerAdapter.getLastIndex());

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AddRecordActivity.class);
                startActivity(intent);
            }
        });


        GlobalUtil.getInstance().setContext(getApplicationContext());
        GlobalUtil.getInstance().databaseHelper.readRecords("2017-10-10");
        GlobalUtil.getInstance().databaseHelper.readRecords("2017-10-10");
        GlobalUtil.getInstance().databaseHelper.readRecords("2017-10-10");

    }
}
