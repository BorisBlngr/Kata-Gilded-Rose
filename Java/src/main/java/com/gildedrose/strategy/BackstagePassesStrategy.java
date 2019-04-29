package com.gildedrose.strategy;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class BackstagePassesStrategy implements ItemStrategy {
    private TreeMap<Integer, Integer> backstagePassesStages = new TreeMap<Integer, Integer>() {{
        put(0, 3);
        put(5, 2);
        put(10, 1);
    }};

    @Override
    public int computeNewQuality(int sellIn, int quality) {
        int qualityGain = Optional.ofNullable(backstagePassesStages.floorEntry(sellIn))
                .map(Map.Entry::getValue)
                .orElseGet(() -> -quality);

        return Math.min(quality + qualityGain, QUALITY_MAX);
    }
}
