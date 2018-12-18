package cn.edu.nju.jlxy.accounting.gui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import cn.edu.nju.jlxy.accounting.R;
import cn.edu.nju.jlxy.accounting.bean.RecordBean;

import java.util.LinkedList;
import java.util.List;

/**
 * @author WuRJ
 * @Description
 * @time 2018-12-18 20:17
 */


@SuppressLint("ValidFragment")
public class MainFragment extends Fragment {

    private View rootView;
    private TextView textView;
    private ListView listView;
    private ListViewAdapter listViewAdapter;

    private List<RecordBean> recordBeans=new LinkedList<>();

    private String date="";

    @SuppressLint("ValidFragment")
    public MainFragment(String date) {
        this.date = date;

        recordBeans.add(new RecordBean());
        recordBeans.add(new RecordBean());
        recordBeans.add(new RecordBean());
        recordBeans.add(new RecordBean());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_main,container,false);
        initView();
        return rootView;
    }


    private void initView(){
        textView=(TextView)rootView.findViewById(R.id.day_text);
        listView=(ListView)rootView.findViewById(R.id.listView);

        textView.setText(date);


        listViewAdapter=new ListViewAdapter(getContext());
        listViewAdapter.setData(recordBeans);
        listView.setAdapter(listViewAdapter);

        if (listViewAdapter.getCount()>0){
            rootView.findViewById(R.id.no_record_layout).setVisibility(View.INVISIBLE);
        }
    }


}
