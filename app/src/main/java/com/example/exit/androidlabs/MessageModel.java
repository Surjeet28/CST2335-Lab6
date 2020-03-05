package com.example.exit.androidlabs;

public class MessageModel {
    public String message;
    public boolean isSend;

    public MessageModel(String message, boolean isSend) {
        this.message = message;
        this.isSend = isSend;
    }

    public MessageModel() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }
}
