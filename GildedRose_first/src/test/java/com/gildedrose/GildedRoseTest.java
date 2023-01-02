package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    @Test
        // Quality of an item can never be negative
    void potentialNegativeQualityTest() {
        Item[] items = new Item[] {new Item("Elixir of the Mongoose", 5, 0, true, false, false) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
    @Test
        // SellIn value has to be decreased by 1 to all products except for Sulfuras
    void sellInChangeTest() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 4, false, false, false) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
        // SellIn value has to be decreased by 1 to all products except for Sulfuras
    void sellInChangeTestSulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80, false, false, true) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
    }
    @Test
        // Aged Brie always increases in quality, sellIn > 0 = double quality increase
    void agedBrieQualityNegativeSellin() {
        Item[] items = new Item[] { new Item("Aged Brie", -2, 4, false, false, false) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }
    @Test
        // Aged Brie always increases in quality, sellIn
    void agedBrieQualityPositiveSellin() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 4, false) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].quality);
    }
    @Test
        // Sulfuras never changes quality, no matter the sellIn value
    void sulfurasZeroSellin() {
        Item[] items = {new Item("Sulfuras, Hand of Ragnaros", 0, 80, false) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }
    @Test
        // Sulfuras never changes quality, no matter the sellIn value
    void sulfurasNegativeSellin() {
        Item[] items = {new Item("Sulfuras, Hand of Ragnaros", -1, 80, false) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }
    @Test
        // Conjured items lose quality twice as fast as other products, also when sellIn is negative
    void conjuredNegativeSellin() {
        Item[] items = {new Item("Conjured Mana Cake", -1, 6, true) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }
    @Test
        // Conjured items lose quality twice as fast as other products, also when sellIn is negative
    void conjuredPositiveSellin() {
        Item[] items = {new Item("Conjured Mana Cake", 3, 6, true) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }
    @Test
        // Backstage Passes increase in value:
        // +1 when sellIn > 10, +2 when sellIn between =5 and =10, +3 when sellIn <= 5,
        // quality = 0 when sellIn is negative
        // quality for products cant exceed past 50
    void backstagePassesSellinFiveorLessMaxTest() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 3, 49, false) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    @Test
        // Backstage Passes increase in value:
        // +1 when sellIn > 10, +2 when sellIn between =5 and =10, +3 when sellIn <= 5
        // quality = 0 when sellIn is negative
        // quality for products cant exceed past 50
    void backstagePassesSellinBetweenTenAndSixMaxTest() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 7, 49, false) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    @Test
        // Backstage Passes increase in value:
        // +1 when sellIn > 10, +2 when sellIn between =5 and =10, +3 when sellIn <= 5
        // quality = 0 when sellIn is negative
        // quality for products cant exceed past 50
    void backstagePassesNegativeSellin() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", -5, 49, false) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
    @Test
        // Backstage Passes increase in value:
        // +1 when sellIn > 10, +2 when sellIn between =5 and =10, +3 when sellIn <= 5
        // quality = 0 when sellIn is negative
        // quality for products cant exceed past 50
    void backstagePassesSellinFiveorLess() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 3, 40, false) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(43, app.items[0].quality);
    }
    @Test
        // Backstage Passes increase in value:
        // +1 when sellIn > 10, +2 when sellIn between =5 and =10, +3 when sellIn <= 5
        // quality = 0 when sellIn is negative
        // quality for products cant exceed past 50
    void backstagePassesSellinBetweenTenAndSix() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 7, 40, false)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(42, app.items[0].quality);
    }
}