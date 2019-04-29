package com.gildedrose.strategy;

public class ConjuredManaCakeStrategy implements ItemStrategy {
    @Override
    public int computeNewQuality(int sellIn, int quality) {
        return this.getNewQualityForDecreasableItemWithRate(sellIn, quality, 2);
    }
}
