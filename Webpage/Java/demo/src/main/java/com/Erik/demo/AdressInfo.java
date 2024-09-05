package com.Erik.demo;

public class AdressInfo {
    private String name;
    private long id;
    private String adress;

    public AdressInfo(String name, long id, String adress) {
        this.name = name;
        this.id = id;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public long getId() {
        return id;
    }
}
