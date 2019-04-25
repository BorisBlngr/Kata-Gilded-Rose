package com.gildedrose;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

class ItemStrategies {

    private Map<String, BiFunction<Integer, Integer, Integer>> strategies;
    private BiFunction<Integer, Integer, Integer> defaultStrategy;


    ItemStrategies() {
        this.strategies = new HashMap<>();
        this.strategies.put(GildedRose.AGED_BRIE, this::getNewQualityForAgedBrie);
        this.strategies.put(GildedRose.BACKSTAGE_PASSES, this::getNewQualityForBackstagePasses);
        this.strategies.put(GildedRose.SULFURAS_HAND_OF_RAGNAROS, this::getNewQualityForLegendaryItem);

        this.defaultStrategy = this::getNewQualityForCommonItems;
    }

    BiFunction<Integer, Integer, Integer> getStrategyFor(String itemName) {
        return this.strategies.getOrDefault(itemName, this.defaultStrategy);
    }

    private int getNewQualityForAgedBrie(final int sellIn, final int quality) {
        int newQuality = quality;
        if (sellIn < 0) {
            if (quality < 50) {
                newQuality = quality + 2 > 50 ? 50 : quality + 2;

            }
        } else {
            if (quality < 50) {
                newQuality = quality + 1;
            }
        }
        return newQuality;
    }

    private int getNewQualityForLegendaryItem(int sellIn, int quality) {
        return quality;
    }

    private int getNewQualityForBackstagePasses(int sellIn, int quality) {
        int newQuality = quality;
        if (sellIn >= 10) {
            if (quality < 50) {
                newQuality = quality + 1;
            }
        } else if (sellIn >= 5) {
            if (quality < 50) {
                newQuality = quality + 2 > 50 ? 50 : quality + 2;
            }
        } else if (sellIn >= 0) {
            if (quality < 50) {
                newQuality = quality + 3 > 50 ? 50 : quality + 3;
            }
        } else {
            newQuality = 0;
        }

        return newQuality;
    }

    private int getNewQualityForCommonItems(int sellIn, int quality) {
        int newQuality = quality;
        if (sellIn < 0) {
            if (quality > 0) {
                newQuality = quality - 2 < 0 ? 0 : quality - 2;
            }
        } else {
            if (quality > 0) {
                newQuality = quality - 1;
            }
        }

        return newQuality;
    }
}