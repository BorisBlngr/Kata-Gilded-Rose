package com.gildedrose;

import com.gildedrose.item.WrappedItems;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void update() {
        WrappedItems.of(items).updateAll();
    }
}