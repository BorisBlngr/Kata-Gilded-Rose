package com.gildedrose.strategy;

public interface ItemStrategy {
    int QUALITY_MIN = 0;
    int QUALITY_MAX = 50;

    default int getNewQualityForDecreasableItemWithRate(int sellIn, int quality, int rate) {
        int applicableRate = sellIn < 0 ? rate * 2 : rate;
        return Math.max(quality - applicableRate, QUALITY_MIN);
    }

    int computeNewQuality(int sellIn, int quality);

    default int computeNewSellIn(int sellIn) {
        return sellIn - 1;
    }
}
