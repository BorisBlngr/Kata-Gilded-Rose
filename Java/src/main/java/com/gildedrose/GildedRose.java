package com.gildedrose;

import com.gildedrose.item.WrappedItems;

public class GildedRose {
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update() {
        WrappedItems.of(items)
                .updateAll();
    }
}