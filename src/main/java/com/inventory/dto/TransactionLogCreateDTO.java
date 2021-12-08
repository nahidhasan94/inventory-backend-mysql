package com.inventory.dto;


import java.util.List;

public class TransactionLogCreateDTO {
    private List<CheckOutDTO> checkOutDTOS;
    private String customerName;
    private String mobileNumber;
    private int total;

    public TransactionLogCreateDTO() {
    }

    public List<CheckOutDTO> getCheckOutDTOS() {
        return checkOutDTOS;
    }

    public void setCheckOutDTOS(List<CheckOutDTO> checkOutDTOS) {
        this.checkOutDTOS = checkOutDTOS;
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
}
