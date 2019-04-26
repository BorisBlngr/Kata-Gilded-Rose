package com.gildedrose;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

class ItemStrategies {

    private static final int QUALITY_MAX = 50;
    private static final int QUALITY_MIN = 0;
    private static final int SIMPLE_INCREASE_LIMIT = 10;
    private static final int DOUBLE_INCREASE_LIMIT = 5;
    private static final int TRIPLE_INCREASE_LIMIT = 0;
    private Map<String, BiFunction<Integer, Integer, Integer>> strategies;
    private BiFunction<Integer, Integer, Integer> defaultStrategy;


    ItemStrategies() {
        this.strategies = new HashMap<>();
        this.strategies.put(GildedRose.AGED_BRIE, this::getNewQualityForAgedBrie);
        this.strategies.put(GildedRose.BACKSTAGE_PASSES, this::getNewQualityForBackstagePasses);
        this.strategies.put(GildedRose.SULFURAS_HAND_OF_RAGNAROS, this::getNewQualityForLegendaryItem);
        this.strategies.put(GildedRose.CONJURED_MANA_CAKE, this::getNewQualityForConjuredManaCake);

        this.defaultStrategy = this::getNewQualityForCommonItems;
    }

    BiFunction<Integer, Integer, Integer> getStrategyFor(String itemName) {
        return this.strategies.getOrDefault(itemName, this.defaultStrategy);
    }

    private int getNewQualityForAgedBrie(final int sellIn, final int quality) {
        int increaseNumber = sellIn < 0 ? 2 : 1;
        return Math.min(quality + increaseNumber, QUALITY_MAX);
    }

    private int getNewQualityForLegendaryItem(int sellIn, int quality) {
        return quality;
    }

    private int getNewQualityForBackstagePasses(int sellIn, int quality) {
        int newQuality = quality;
        if (sellIn >= SIMPLE_INCREASE_LIMIT) {
            if (quality < QUALITY_MAX) {
                newQuality = quality + 1;
            }
        } else if (sellIn >= DOUBLE_INCREASE_LIMIT) {
            if (quality < QUALITY_MAX) {
                newQuality = Math.min(quality + 2, QUALITY_MAX);
            }
        } else if (sellIn >= TRIPLE_INCREASE_LIMIT) {
            if (quality < QUALITY_MAX) {
                newQuality = Math.min(quality + 3, QUALITY_MAX);
            }
        } else {
            newQuality = QUALITY_MIN;
        }

        return newQuality;
    }

    private int getNewQualityForCommonItems(int sellIn, int quality) {
        return getNewQualityForDecreasableItemWithRate(sellIn, quality, 1);
    }

    private int getNewQualityForConjuredManaCake(int sellIn, int quality) {
        return getNewQualityForDecreasableItemWithRate(sellIn, quality, 2);
    }

    private int getNewQualityForDecreasableItemWithRate(int sellIn, int quality, int rate) {
        int applicableRate = sellIn < 0 ? rate * 2 : rate;
        return Math.max(quality - applicableRate, QUALITY_MIN);
    }
}