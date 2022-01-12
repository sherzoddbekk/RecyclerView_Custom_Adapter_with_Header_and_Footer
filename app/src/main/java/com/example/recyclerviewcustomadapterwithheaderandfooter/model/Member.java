package com.example.recyclerviewcustomadapterwithheaderandfooter.model;

public class Member {
    private String first_name;
    private String last_name;
    private boolean available = false;

    public Member(String first_name, String last_name, boolean available) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.available = available;
    }

    public Member() {
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
