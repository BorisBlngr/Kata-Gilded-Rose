package com.gildedrose.item;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BackstagePassTest {

    @Test
    public void backstage_increase_by_1_when_sellIn_is_over_10() {
        Item[] items = new Item[]{new Item(ItemFactory.BACKSTAGE_PASSES, 12, 20)};
        GildedRose app = new GildedRose(items);
        app.update();

        assertThat(app.items[0].quality).isEqualTo(21);
    }

    @Test
    public void backstage_increase_by_2_when_sellIn_is_between_10_and_6() {
        Item[] items = new Item[]{new Item(ItemFactory.BACKSTAGE_PASSES, 9, 20)};
        GildedRose app = new GildedRose(items);
        app.update();

        assertThat(app.items[0].quality).isEqualTo(22);
    }

    @Test
    public void backstage_increase_by_3_when_sellIn_is_between_6_and_0() {
        Item[] items = new Item[]{new Item(ItemFactory.BACKSTAGE_PASSES, 4, 20)};
        GildedRose app = new GildedRose(items);
        app.update();

        assertThat(app.items[0].quality).isEqualTo(23);
    }

    @Test
    public void backstage_quality_is_0_when_sellIn_is_lower_than_0() {
        Item[] items = new Item[]{new Item(ItemFactory.BACKSTAGE_PASSES, 0, 20)};
        GildedRose app = new GildedRose(items);
        app.update();

        assertThat(app.items[0].quality).isEqualTo(0);
    }
}