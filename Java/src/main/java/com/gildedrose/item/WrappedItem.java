package com.gildedrose.item;

import com.gildedrose.Item;

import java.util.Objects;

import static java.lang.Math.max;

public abstract class WrappedItem {
    protected final static int QUALITY_MIN = 0;
    protected Item item;

    WrappedItem(Item item) {
        this.item = item;
    }

    void update() {
        updateSellIn();
        updateQuality();
    }

    protected abstract void updateQuality();

    protected abstract void updateSellIn();

    int getNewQualityForDecreasableItemWithRate(int sellIn, int quality, int rate) {
        int applicableRate = sellIn < 0 ? rate * 2 : rate;
        return max(quality - applicableRate, QUALITY_MIN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrappedItem that = (WrappedItem) o;
        return Objects.equals(item.name, that.item.name) &&
                Objects.equals(item.quality, that.item.quality) &&
                Objects.equals(item.sellIn, that.item.sellIn);
    }

    @Override
    public int hashCode() {
        return item != null ? item.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "WrappedItem{" +
                "name: " + item.name + ", " +
                "sellIn: " + item.sellIn + ", " +
                "quality: " + item.quality +
                '}';
    }
}