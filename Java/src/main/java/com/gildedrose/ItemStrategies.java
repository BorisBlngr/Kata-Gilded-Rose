package com.gildedrose;

import com.gildedrose.strategy.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

class ItemStrategies {

    private Map<String, BiFunction<Integer, Integer, Integer>> strategies;
    private BiFunction<Integer, Integer, Integer> defaultStrategy;


    ItemStrategies() {
        this.strategies = new HashMap<>();
        this.strategies.put(GildedRose.AGED_BRIE, (sellIn, quality) -> new AgedBrieStrategy().computeNewQuality(sellIn, quality));
        this.strategies.put(GildedRose.BACKSTAGE_PASSES, (sellIn, quality) -> new BackstagePassesStrategy().computeNewQuality(sellIn, quality));
        this.strategies.put(GildedRose.SULFURAS_HAND_OF_RAGNAROS, (sellIn, quality) -> new LegendaryItemStrategy().computeNewQuality(sellIn, quality));
        this.strategies.put(GildedRose.CONJURED_MANA_CAKE, (sellIn, quality) -> new ConjuredManaCakeStrategy().computeNewQuality(sellIn, quality));

        this.defaultStrategy = new CommonItemStrategy()::computeNewQuality;
    }

    BiFunction<Integer, Integer, Integer> getStrategyFor(String itemName) {
        return this.strategies.getOrDefault(itemName, this.defaultStrategy);
    }

}