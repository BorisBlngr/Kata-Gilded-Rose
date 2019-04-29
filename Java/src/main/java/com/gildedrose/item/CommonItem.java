package com.gildedrose.item;

import com.gildedrose.Item;

class CommonItem extends WrappedItem {
    CommonItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        item.quality = getNewQualityForDecreasableItemWithRate(item.sellIn, item.quality, 1);
    }

    @Override
    protected void updateSellIn() {
        this.item.sellIn--;
    }
}
