package com.gildedrose;


public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public boolean isDegradable;

    public boolean isConjuredItem;

    public boolean isLegendaryItem;



    public Item(String name, int sellIn, int quality, boolean isDegradable, boolean isConjuredItem, boolean isLegendaryItem) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.isDegradable = isDegradable;
        this.isConjuredItem = isConjuredItem;
        this.isLegendaryItem = isLegendaryItem;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality; }
}