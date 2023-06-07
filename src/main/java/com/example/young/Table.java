package com.example.young;

public class Table {
    public String name;
    public int count;

    public double getPriceBuy() {
        return priceBuy;
    }

    public double getPriceNow() {
        return priceNow;
    }

    public double getPercent() {
        return percent;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public double priceBuy, priceNow, percent;

    public Table(String name, int count, double priceBuy, double priceNow, double percent){
        this.name = name;
        this.count = count;
        this.priceBuy = priceBuy;
        this.priceNow = priceNow;
        this.percent = percent;
    }
}
