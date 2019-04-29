package com.gildedrose.item;

import com.gildedrose.Item;

class AgedBrie extends WrappedItem {
    AgedBrie(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        int increaseNumber = item.sellIn < 0 ? 2 : 1;
        item.quality = Math.min(item.quality + increaseNumber, QUALITY_MAX);
    }

    @Override
    protected void updateSellIn() {
        --item.sellIn;
    }
}