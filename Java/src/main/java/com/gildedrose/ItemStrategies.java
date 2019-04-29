package com.gildedrose;

import com.gildedrose.strategy.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

class ItemStrategies {

    private Map<String, ItemStrategy> strategies;
    private ItemStrategy defaultStrategy;


    ItemStrategies() {
        this.strategies = new HashMap<>();
        this.strategies.put(GildedRose.AGED_BRIE, new AgedBrieStrategy());
        this.strategies.put(GildedRose.BACKSTAGE_PASSES, new BackstagePassesStrategy());
        this.strategies.put(GildedRose.SULFURAS_HAND_OF_RAGNAROS, new LegendaryItemStrategy());
        this.strategies.put(GildedRose.CONJURED_MANA_CAKE, new ConjuredManaCakeStrategy());

        this.defaultStrategy = new CommonItemStrategy();
    }

    BiFunction<Integer, Integer, Integer> getQualityStrategyFor(String itemName) {
        return this.strategies.getOrDefault(itemName, this.defaultStrategy)::computeNewQuality;
    }

    Function<Integer, Integer> getSellInStrategyFor(String itemName) {
        return this.strategies.getOrDefault(itemName, this.defaultStrategy)::computeNewSellIn;
    }

}