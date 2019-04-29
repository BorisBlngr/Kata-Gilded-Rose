package com.gildedrose.item;

import com.gildedrose.Item;

import static java.lang.Math.min;

class AgedBrie extends VariableItem {
    AgedBrie(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        int increaseNumber = item.sellIn < 0 ? 2 : 1;
        item.quality = min(item.quality + increaseNumber, QUALITY_MAX);
    }

    @Override
    protected void updateSellIn() {
        --item.sellIn;
    }
}
