package com.gildedrose.strategy;

public class AgedBrieStrategy implements ItemStrategy {

    @Override
    public int computeNewQuality(int sellIn, int quality) {
        int increaseNumber = sellIn < 0 ? 2 : 1;
        return Math.min(quality + increaseNumber, QUALITY_MAX);
    }
}
