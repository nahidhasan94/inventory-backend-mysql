package com.inventory.dto;

import java.util.Date;

//useless dto
public class TransactionLogUpdateDTO {
    private String billNo;
    private String items;
    private String name;
    private String mobileNumber;
    private int total;
    private Date date;

    public TransactionLogUpdateDTO() {
    }

    public TransactionLogUpdateDTO(String billNo, String items, String name, String mobileNumber, int total, Date date) {
        this.billNo = billNo;
        this.items = items;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.total = total;
        this.date = date;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
