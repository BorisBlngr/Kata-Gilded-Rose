package com.gildedrose;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Aged Brie")
                    || item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                increaseQualityOf(item);

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        increaseQualityOf(item);
                    }

                    if (item.sellIn < 6) {
                        increaseQualityOf(item);
                    }
                }
            } else {
                lowerQualityOf(item);
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn--;
            }

            if (item.sellIn < 0) {
                if (item.name.equals("Aged Brie")) {
                    increaseQualityOf(item);
                } else {
                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        item.quality = 0;
                    } else {
                        lowerQualityOf(item);
                    }
                }
            }
        }
    }

    private void increaseQualityOf(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void lowerQualityOf(Item item) {
        if (item.quality > 0) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.quality--;
            }
        }
    }
}