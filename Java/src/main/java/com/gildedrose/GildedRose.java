package com.gildedrose;

class GildedRose {
    static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    static final String AGED_BRIE = "Aged Brie";
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            if (isLegendary(item)) {
                item.quality = getNewQualityForLegendaryItem(item.sellIn, item.quality);
            } else if (isAgedBrie(item)) {
                decreaseSellIn(item);
                item.quality = getNewQualityForAgedBrie(item.quality, item.sellIn);
            } else if (isBackstage(item)) {
                decreaseSellIn(item);
                item.quality = getNewQualityForBackstagePasses(item.sellIn, item.quality);
            } else {
                decreaseSellIn(item);
                item.quality = getNewQualityForCommonItems(item.sellIn, item.quality);
            }
        }
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

    private int getNewQualityForAgedBrie(final int quality, final int sellIn) {
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

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    private boolean isLegendary(Item item) {
        return item.name.equals(SULFURAS_HAND_OF_RAGNAROS);
    }

    private boolean isBackstage(Item item) {
        return item.name.equals(BACKSTAGE_PASSES);
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals(AGED_BRIE);
    }
}