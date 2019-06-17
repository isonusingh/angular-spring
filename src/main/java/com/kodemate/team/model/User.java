package com.kodemate.team.model;

public class User {
    private String status;

    public User(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User [status=" + status + "]";
    }

}
