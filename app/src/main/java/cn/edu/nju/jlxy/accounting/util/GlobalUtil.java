package cn.edu.nju.jlxy.accounting.util;

import android.content.Context;
import cn.edu.nju.jlxy.accounting.db.DBSql;
import cn.edu.nju.jlxy.accounting.db.RecordDatabaseHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WuRJ
 * @Description
 * @time 2018-12-19 15:04
 */
public class GlobalUtil {

    private static GlobalUtil instance;

    public RecordDatabaseHelper databaseHelper;
    public Context context;

    public static List<CategoryBean> cost=new ArrayList<>();
    public static List<CategoryBean> earn=new ArrayList<>();

    private static List<String> costTitle= Arrays.asList();
    private static List<String> earnTitle=Arrays.asList();
    private static List<Integer> costBlack= Arrays.asList();
    private static List<Integer> earnBlack=Arrays.asList();
    private static List<Integer> costWhite= Arrays.asList();
    private static List<Integer> earnWhite=Arrays.asList();




    public static GlobalUtil getInstance() {
        if (instance==null){
            instance=new GlobalUtil();
        }
        return instance;
    }


    public void setDatabaseHelper(RecordDatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        databaseHelper=new RecordDatabaseHelper(context, DBSql.DB_NAME,null,1);

        for (int i=0;i<costTitle.size();i++){
            CategoryBean re=new CategoryBean();
            re.title=costTitle.get(i);
            re.resBlack=costBlack.get(i);
            re.resWite=costWhite.get(i);
            cost.add(re);

        }

        for (int i=0;i<earnTitle.size();i++){
            CategoryBean re=new CategoryBean();
            re.title=earnTitle.get(i);
            re.resBlack=earnBlack.get(i);
            re.resWite=earnWhite.get(i);
            earn.add(re);

        }
    }

}
