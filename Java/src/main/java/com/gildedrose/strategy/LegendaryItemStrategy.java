package com.gildedrose.strategy;

public class LegendaryItemStrategy implements ItemStrategy {
    @Override
    public int computeNewQuality(int sellIn, int quality) {
        return quality;
    }

    @Override
    public int computeNewSellIn(int sellIn, int quality) {
        return 0;
    }
}
