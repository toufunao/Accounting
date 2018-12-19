package cn.edu.nju.jlxy.accounting.db;

import android.database.sqlite.SQLiteDatabase;

/**
 * @author WuRJ
 * @Description
 * @time 2018-12-17 20:42
 */
public class DBSql {
    public static final String DB_NAME="Record";

    public static final String create_db="create table Record ("
            +"id integer primary key autoincrement,"
            +"uuid text,"
            +"type integer,"
            +"category text,"
            +"remark text,"
            +"amount double,"
            +"time integer,"
            +"date date)";

    public static final String select_db_bytime="select DISTINCT * from Record where date=? order by time asc";


    public static final String select_db_bydate="select DISTINCE * from Record where date=? order by date asc";
}
