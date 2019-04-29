package com.gildedrose.item;

import com.gildedrose.Item;

class ConjuredItem extends WrappedItem {
    ConjuredItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        this.item.quality = getNewQualityForDecreasableItemWithRate(item.sellIn, item.quality, 2);
    }

    @Override
    protected void updateSellIn() {
        this.item.sellIn--;
    }
}
