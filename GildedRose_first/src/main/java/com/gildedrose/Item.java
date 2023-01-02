package com.gildedrose;


public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public boolean isDegradable;

    public Item(String name, int sellIn, int quality, boolean isDegradable) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.isDegradable = isDegradable;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality; }
}