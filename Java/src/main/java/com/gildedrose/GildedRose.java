package com.gildedrose;

class GildedRose {
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