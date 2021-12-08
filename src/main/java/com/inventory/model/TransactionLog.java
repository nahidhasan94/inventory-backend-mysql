package com.inventory.model;

import com.inventory.dto.CheckOutDTO;
//import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class TransactionLog {
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    private String billNo;
   private String items;
    private String customerName;
    private String mobileNumber;
   // private List<CheckOutDTO> detailsInfo;
    private int total;
    private Date date;
    private String status;

    public TransactionLog() {
    }

    public TransactionLog(String status) {
        this.status = status;
    }

    public TransactionLog(long id, String billNo, String items, String customerName, String mobileNumber, List<CheckOutDTO> detailsInfo, int total, Date date, String status) {
        this.id = id;
        this.billNo = billNo;
        this.items = items;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;;
        this.total = total;
        this.date = date;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public List<CheckOutDTO> getDetailsInfo() {
//        return detailsInfo;
//    }
//
//    public void setDetailsInfo(List<CheckOutDTO> detailsInfo) {
//        this.detailsInfo = detailsInfo;
//    }
}

