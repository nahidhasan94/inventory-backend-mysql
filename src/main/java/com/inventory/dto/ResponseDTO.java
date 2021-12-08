package com.inventory.dto;

public class ResponseDTO<T> {

   private T data;
    private String message;
    private String status;

    public ResponseDTO() {
    }

    public ResponseDTO generateSuccessResponse(T data, String message) {
        this.data = data;
        this.message = message;
        this.status = "success";
        return this;
    }

    public ResponseDTO generateErrorResponse(String message) {
        this.data = null;
        this.message = message;
        this.status = "error";
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
