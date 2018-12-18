package cn.edu.nju.jlxy.accounting.gui;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.edu.nju.jlxy.accounting.R;
import cn.edu.nju.jlxy.accounting.bean.RecordBean;

import java.util.LinkedList;
import java.util.List;

/**
 * @author WuRJ
 * @Description
 * @time 2018-12-18 21:15
 */
public class ListViewAdapter extends BaseAdapter {
    private List<RecordBean> recordBeans=new LinkedList<>();
    private LayoutInflater inflater;
    private Context context;

    public ListViewAdapter(Context context) {
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    public void setData(List<RecordBean> recordBeans){
        this.recordBeans=recordBeans;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return recordBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return recordBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
           convertView=inflater.inflate(R.layout.cell_list_view,null);
           RecordBean bean=(RecordBean) getItem(position);

           holder=new ViewHolder(convertView,bean);

           convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        return convertView;
    }
}

class ViewHolder{
    TextView remarkTV;
    TextView amountTV;
    TextView timeTV;
    ImageView categoryIcon;

    public ViewHolder(View view,RecordBean recordBean){
        remarkTV=(TextView) view.findViewById(R.id.textView_remark);
        amountTV=(TextView)view.findViewById(R.id.textView_amount);
        timeTV=(TextView)view.findViewById(R.id.textView_time);
        categoryIcon=(ImageView) view.findViewById(R.id.imageView_category);

        //remarkTV.setText(recordBean.getRemark());
    }
}