package com.gildedrose;

class GildedRose {
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
            if (isLegendary(item)) {
                item.quality = itemStrategies.getStrategyFor(item.name).apply(item.sellIn, item.quality);
            } else if (isAgedBrie(item)) {
                decreaseSellIn(item);
                item.quality = itemStrategies.getStrategyFor(item.name).apply(item.quality, item.sellIn);
            } else if (isBackstage(item)) {
                decreaseSellIn(item);
                item.quality = itemStrategies.getStrategyFor(item.name).apply(item.sellIn, item.quality);
            } else {
                decreaseSellIn(item);
                item.quality = itemStrategies.getStrategyFor(item.name).apply(item.sellIn, item.quality);
            }
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    private boolean isLegendary(Item item) {
        return item.name.equals(SULFURAS_HAND_OF_RAGNAROS);
    }

    private boolean isBackstage(Item item) {
        return item.name.equals(BACKSTAGE_PASSES);
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals(AGED_BRIE);
    }
}