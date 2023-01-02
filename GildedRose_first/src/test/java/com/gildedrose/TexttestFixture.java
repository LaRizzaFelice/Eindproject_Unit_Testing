package com.gildedrose;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20, true), //
                new Item("Aged Brie", 2, 0, false), //
                new Item("Elixir of the Mongoose", 5, 7, true), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80, false), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80, false),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20, true),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49, false),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49, true),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6, true),
                new Item("Conjured Mana Cake", -1, 6, true) };


        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " +  i  + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
