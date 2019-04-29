package com.gildedrose.strategy;

public class CommonItemStrategy implements ItemStrategy {
    @Override
    public int computeNewQuality(int sellIn, int quality) {
        return getNewQualityForDecreasableItemWithRate(sellIn, quality, 1);
    }
}
