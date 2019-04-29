package com.gildedrose;

class GildedRose {
    static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";
    static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    static final String AGED_BRIE = "Aged Brie";
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        ItemStrategies itemStrategies = new ItemStrategies();
        for (Item item : items) {
            item.sellIn = itemStrategies.getSellInStrategyFor(item.name).apply(item.sellIn);
            item.quality = itemStrategies.getQualityStrategyFor(item.name).apply(item.sellIn, item.quality);
        }
    }
}