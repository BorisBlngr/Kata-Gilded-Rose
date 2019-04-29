package com.gildedrose.item;

import com.gildedrose.Item;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class BackstagePassItem extends WrappedItem {
    private TreeMap<Integer, Integer> backstagePassesStages = new TreeMap<Integer, Integer>() {{
        put(0, 3);
        put(5, 2);
        put(10, 1);
    }};

    BackstagePassItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        int qualityGain = Optional.ofNullable(backstagePassesStages.floorEntry(this.item.sellIn))
                .map(Map.Entry::getValue)
                .orElseGet(() -> -item.quality);

        item.quality = Math.min(this.item.quality + qualityGain, QUALITY_MAX);
    }

    @Override
    protected void updateSellIn() {
        item.sellIn--;
    }

}
