package com.gildedrose.item;

import com.gildedrose.Item;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import static java.lang.Math.min;

public class BackstagePass extends VariableItem {
    private TreeMap<Integer, Integer> backstagePassesStages = new TreeMap<Integer, Integer>() {{
        put(0, 3);
        put(5, 2);
        put(10, 1);
    }};

    BackstagePass(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        int qualityGain = Optional.ofNullable(backstagePassesStages.floorEntry(this.item.sellIn))
                .map(Map.Entry::getValue)
                .orElseGet(() -> -item.quality);

        item.quality = min(this.item.quality + qualityGain, QUALITY_MAX);
    }

    @Override
    protected void updateSellIn() {
        item.sellIn--;
    }

}
