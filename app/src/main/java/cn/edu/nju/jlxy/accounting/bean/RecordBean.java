package cn.edu.nju.jlxy.accounting.bean;

import cn.edu.nju.jlxy.accounting.util.DateUtil;

import java.util.UUID;

/**
 * @author WuRJ
 * @Description
 * @time 2018-12-17 20:11
 */
public class RecordBean {
    public enum RecordType{
        EXPENSE,INCOME
    }
    private double amount;
    private RecordType type;
    private String category;
    private String remark;
    private String date;
    private long timeStamp;

    private String uuid;



    public RecordBean() {
        uuid= UUID.randomUUID().toString();//唯一识别一笔记账
        date= DateUtil.getFormattedDate();
        timeStamp=System.currentTimeMillis();

    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getType() {
        if (this.type.equals(RecordType.EXPENSE)){
            return 1;
        }else {
            return 0;
        }

    }

    public void setType(int type) {
        if (type==1){
            this.type=RecordType.EXPENSE;
        }else {
            this.type=RecordType.INCOME;
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}
