package com.iris.utils;

public class ResponseBodyVO {
    private boolean ok;
    private String message;
    private Object data;

    public ResponseBodyVO() {

    }

    public ResponseBodyVO(Exception ex) {
        ok = false;
        message = String.format("(%s) %s", ex.getClass().getName(), ex.getMessage());
    }

    public ResponseBodyVO(Object data) {
        ok = true;
        message = "Operation execute completed.";
        this.data = data;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
