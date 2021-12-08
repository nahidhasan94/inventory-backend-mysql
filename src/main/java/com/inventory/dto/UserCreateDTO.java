package com.inventory.dto;

public class UserCreateDTO {
    private String name;
    private String username;
    private String mobileNumber;
    private String password;
    private String address;
    private String adminPassword;

    public UserCreateDTO() {
    }

    public UserCreateDTO(String name, String username, String mobileNumber, String password, String address, String adminPassword) {
        this.name = name;
        this.username = username;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.address = address;
        this.adminPassword = adminPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

}
