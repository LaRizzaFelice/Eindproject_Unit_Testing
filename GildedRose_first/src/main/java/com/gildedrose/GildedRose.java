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
                //The Quality of an item is never negative
                if (items[i].quality > 0) {
                    //Sulfuras can not lose quality (so never -1 in quality)
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }

                }
                //talking about items which value rise each day (=Backstage Pass)
            } else {
                //The Quality of an item is never more than 50
                if (items[i].quality < 50) {
                    //first day of two : Quality increases by 2 when there are 10 days or less
                    items[i].quality = items[i].quality + 1;
                    //"Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        // if sellIn is 10 days or less and if quality is less than 50 , then increase quality by 1
                        // at this point quality will be increased by 2
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                //second day of two : Quality increases by 2 when there are 10 days or less
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                        // if sellIn is 5 days or less and if quality is less than 50 , then increase quality by 1
                        // at this point quality will be increased by 3
                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }
            // SellIn value has to be decreased by 1 to all product except for Sulfuras
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }
            //same code as first block under for loop - does the same!
            if (items[i].sellIn < 0) {
                // if name = Aged Brie, the go to ELSE
                if (!items[i].name.equals("Aged Brie")) {
                    //if name = backstage passes , then go to ELSE
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            //Sulfuras can not lose quality (so never -1 in quality)
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                //all items, beside Aged Brie, Backstage PAsses and Sulfuras lower 1 in quality
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        //Quality drops to 0 after the concert - only for tickets
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    // adds 1 to quality of Aged Brie
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}