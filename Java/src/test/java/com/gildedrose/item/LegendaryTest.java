package com.gildedrose.item;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LegendaryTest {

    @Test
    public void legendary_item_never_decrease_in_quality() {
        Item[] items = new Item[]{new Item(ItemFactory.SULFURAS_HAND_OF_RAGNAROS, 0, 80)};
        GildedRose app = new GildedRose(items);
        app.update();

        assertThat(app.items[0].quality).isEqualTo(80);
    }

    @Test
    public void legendary_item_never_decrease_in_sellIn() {
        Item[] items = new Item[]{new Item(ItemFactory.SULFURAS_HAND_OF_RAGNAROS, 2, 80)};
        GildedRose app = new GildedRose(items);
        app.update();

        assertThat(app.items[0].sellIn).isEqualTo(2);
    }
}