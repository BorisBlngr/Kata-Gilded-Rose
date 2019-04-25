package com.gildedrose;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            decreaseSellIn(item);
            if (isAgedBrie(item)) {
                if (item.sellIn < 0) {
                    increaseQualityOf(item, 2);
                } else {
                    increaseQualityOf(item, 1);
                }
            } else if (isBackstage(item)) {
                if (item.sellIn >= 10) {
                    increaseQualityOf(item, 1);
                } else if (item.sellIn >= 5) {
                    increaseQualityOf(item, 2);
                } else if (item.sellIn >= 0) {
                    increaseQualityOf(item, 3);
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.sellIn < 0) {
                    lowerQualityOf(item, 2);
                } else {
                    lowerQualityOf(item, 1);
                }
            }
        }
    }

    private void decreaseSellIn(Item item) {
        if (isNotLegendary(item)) {
            item.sellIn--;
        }
    }

    private boolean isNotLegendary(Item item) {
        return !item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstage(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private void increaseQualityOf(Item item, int number) {
        if (item.quality < 50) {
            item.quality = item.quality + number > 50 ? 50 : item.quality + number;
        }
    }

    private void lowerQualityOf(Item item, int number) {
        if (item.quality > 0) {
            if (isNotLegendary(item)) {
                item.quality = item.quality - number < 0 ? 0 : item.quality - number;
            }
        }
    }
}