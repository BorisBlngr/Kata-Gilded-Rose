package com.gildedrose.item;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonTest {
    @Test
    public void common_item_decrease_in_quality() {
        Item[] items = new Item[]{new Item("foo", 2, 2)};
        GildedRose app = new GildedRose(items);
        app.update();

        assertThat(app.items[0].quality).isEqualTo(1);
    }

    @Test
    public void common_item_decrease_in_quality_by_2_when_sellIn_is_negative() {
        Item[] items = new Item[]{new Item("foo", 0, 2)};
        GildedRose app = new GildedRose(items);
        app.update();

        assertThat(app.items[0].quality).isEqualTo(0);
    }
}