package cn.edu.nju.jlxy.accounting.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.edu.nju.jlxy.accounting.bean.RecordBean;

import java.util.LinkedList;
import java.util.List;

/**
 * @author WuRJ
 * @Description
 * @time 2018-12-17 20:33
 */
public class RecordDatabaseHelper extends SQLiteOpenHelper {



    public RecordDatabaseHelper( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBSql.create_db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addRecord(RecordBean bean){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("uuid",bean.getUuid());
        contentValues.put("type",bean.getType());
        contentValues.put("category",bean.getType());
        contentValues.put("remark",bean.getRemark());
        contentValues.put("amount",bean.getAmount());
        contentValues.put("date",bean.getDate());
        contentValues.put("time",bean.getTimeStamp());
        db.insert(DBSql.DB_NAME,null,contentValues);
    }

    public void removeRecord(String uuid){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(DBSql.DB_NAME,"uuid=?",new String[]{uuid});
    }

    public void editRecord(String uuid, RecordBean recordBean){
        removeRecord(uuid);
        recordBean.setUuid(uuid);
        addRecord(recordBean);
    }

    public List<RecordBean> readRecords(String dateStr){
        SQLiteDatabase db=this.getWritableDatabase();
        List<RecordBean> recordBeanList=new LinkedList<>();
        Cursor cursor=db.rawQuery(DBSql.select_db_bytime,new String[]{dateStr});

        if (cursor.moveToFirst()){
            do {
                String uuid=cursor.getString(cursor.getColumnIndex("uuid"));
                int type=cursor.getInt(cursor.getColumnIndex("type"));
                String category=cursor.getString(cursor.getColumnIndex("category"));
                String remark=cursor.getString(cursor.getColumnIndex("remark"));
                double amount=cursor.getDouble(cursor.getColumnIndex("amount"));
                String date=cursor.getString(cursor.getColumnIndex("date"));
                long timeStamp=cursor.getLong(cursor.getColumnIndex("time"));

                RecordBean recordBean=new RecordBean();
                recordBean.setUuid(uuid);
                recordBean.setType(type);
                recordBean.setAmount(amount);
                recordBean.setDate(date);
                recordBean.setRemark(remark);
                recordBean.setTimeStamp(timeStamp);
                recordBean.setCategory(category);

                recordBeanList.add(recordBean);

            }while (cursor.moveToNext());
        }

        cursor.close();
        return recordBeanList;
    }


    public List<String> getAvailableDate(){
        List<String> dates=new LinkedList<>();
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(DBSql.select_db_bydate,new String[]{});
        if (cursor.moveToFirst()){
            do {
                String  date=cursor.getString(cursor.getColumnIndex("date"));
                if (!dates.contains(date)){
                    dates.add(date);
                }

            }while (cursor.moveToNext());
        }
        cursor.close();
        return dates;
    }
}
