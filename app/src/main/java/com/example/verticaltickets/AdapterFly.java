package com.example.verticaltickets;

public class AdapterFly {

    private String f_from, f_to, f_date, f_time, f_cost;

    public AdapterFly(String f_from, String f_to, String f_date, String f_time, String f_cost) {
        this.f_from = f_from;
        this.f_to = f_to;
        this.f_date = f_date;
        this.f_time = f_time;
        this.f_cost = f_cost;
    }

    public String getF_from() {
        return f_from;
    }

    public void setF_from(String f_from) {
        this.f_from = f_from;
    }

    public String getF_to() {
        return f_to;
    }

    public void setF_to(String f_to) {
        this.f_to = f_to;
    }

    public String getF_date() {
        return f_date;
    }

    public void setF_date(String f_date) {
        this.f_date = f_date;
    }

    public String getF_time() {
        return f_time;
    }

    public void setF_time(String f_time) {
        this.f_time = f_time;
    }

    public String getF_cost() {
        return f_cost;
    }

    public void setF_cost(String f_cost) {
        this.f_cost = f_cost;
    }
}
