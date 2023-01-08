package com.gildedrose;

public class GildedRose_Refactored {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured Mana Cake";
    Item[] items;

    public GildedRose_Refactored(Item[] items) {
        this.items = items;
    }

    /**
     *This method iterates over all items of the shop and then updates their quality
     *
     */

    //extracted item into a new variable
    //extract new method 'updateItemQuality' and implement with item variable
    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    /**
     * This method updates the quality of the given item
     *
     * @param item, certain item of the shop list
     */
    //extracted constants and name them to have convention in our code

    private static void updateItemQuality(Item item) {
        //degradeRate to degrade -2 or -1, if Conjured = -2 otherwise -1
        int degradeRate = item.name.equals(CONJURED) ? -2 : -1;
        //following 3 items don't degrade until they go to zero, they don't degrade like normal products
        //boolean doesDegrade compares if one of the following is not one of those 3 items (BRIE/BACKSTAGE/SULFURAS)
        boolean doesDegrade = !item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE_PASSES) && !item.name.equals(SULFURAS);
        if (doesDegrade) {
            adjustQuality(item, degradeRate);
        }
        if (item.name.equals(AGED_BRIE)) {
            adjustQuality(item, 1);
            }

        if (item.name.equals(BACKSTAGE_PASSES)) {
            adjustQuality(item, 1);
            if (item.sellIn < 11) {
                adjustQuality(item, 1);
            }

            if (item.sellIn < 6) {
                adjustQuality(item, 1);
            }
        }

        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (doesDegrade) {
                adjustQuality(item, degradeRate);
            }
            if (item.name.equals(AGED_BRIE)) {
                adjustQuality(item, 1);
            //first step = local variable int adjustment
                // item.quality + adjustment = put in new method, see below
            } else {
                //If sellIn BACKSTAGE = below 0 then reset to 0
                if (item.name.equals(BACKSTAGE_PASSES)) {
                    item.quality = item.quality - item.quality;
                }
            }
        }
    }

    /**
     * This method adjusts the quality of the item if the quality value is within the range.
     * @param item , shop item which quality has to be adjusted.
     * @param adjustment , the value by which the quality has to be adjusted.
     */
    //rangeChecking implemented in new method called adjustQuality
    // different (quality) rangeCheckers can be removed in every If or Else statement
    private static void adjustQuality(Item item, int adjustment) {
        //new local variable newQuality where we implement our earlier made adjustment variable
        int newQuality = item.quality + adjustment;
        //via a Boolean method we compare of that statement is correct or not
        boolean isInValidRange = newQuality <= 50 && newQuality >= 0;
        //when true newQuality is set up with that quality item
        if (isInValidRange) {
            item.quality = newQuality;
        }
    }
}