package com.gildedrose;

class GildedRose {
    Item[] items;

    /**
     *
     * @param items
     */
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        // we iterate through our items indexes with a for loop going from 0 to the length of our itemlist
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
                //talking about items which value rise each day (=Backstage Pass)
            } else {
                if (items[i].quality < 50) {
                    //first day of two : Quality increases by 2 when there are 10 days or less
                    items[i].quality = items[i].quality + 1;
                    //"Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                //second day of two : Quality increases by 2 when there are 10 days or less
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                // by 3 when there are 5 days or less but
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }
            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        //Quality drops to 0 after the concert - only for tickets
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}