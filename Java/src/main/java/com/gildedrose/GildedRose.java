package com.gildedrose;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            if (isAgedBrie(item)) {
                increaseQualityOf(item, 1);
            } else if (isBackstage(item)) {
                if (item.sellIn > 10) {
                    increaseQualityOf(item, 1);
                } else if (item.sellIn > 5) {
                    increaseQualityOf(item, 2);
                } else {
                    increaseQualityOf(item, 3);
                }
            } else {
                lowerQualityOf(item);
            }

            if (!isLegendary(item)) {
                item.sellIn--;
            }

            if (item.sellIn < 0) {
                if (isAgedBrie(item)) {
                    increaseQualityOf(item, 1);
                } else {
                    if (isBackstage(item)) {
                        item.quality = 0;
                    } else {
                        lowerQualityOf(item);
                    }
                }
            }
        }
    }

    private boolean isLegendary(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
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

    private void lowerQualityOf(Item item) {
        if (item.quality > 0) {
            if (!isLegendary(item)) {
                item.quality--;
            }
        }
    }
}