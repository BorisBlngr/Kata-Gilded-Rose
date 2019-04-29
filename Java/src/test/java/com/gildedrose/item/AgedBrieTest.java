package com.gildedrose.item;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.gildedrose.item.ItemFactory.AGED_BRIE;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class AgedBrieTest {
    @Parameters({"0,0", "0,1", "1,1"})
    @Test
    public void item_quality_should_never_be_negative(int sellIn, int quality) {
        Item[] items = new Item[]{new Item(AGED_BRIE, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.update();

        assertThat(app.items[0].quality).isGreaterThanOrEqualTo(0);
    }

    @Test
    public void item_quality_should_never_be_greater_that_() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 2, 50)};
        GildedRose app = new GildedRose(items);
        app.update();

        assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    public void item_decrease_in_sellIn() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 2, 49)};
        GildedRose app = new GildedRose(items);
        app.update();

        assertThat(app.items[0].sellIn).isEqualTo(1);
    }

    @Test
    public void brie_increase_by_1_when_sellIn_is_positive() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 2, 34)};
        GildedRose app = new GildedRose(items);
        app.update();

        assertThat(app.items[0].quality).isEqualTo(35);
    }

    @Test
    public void brie_increase_by_2_when_sellIn_is_strict_negative() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 0, 34)};
        GildedRose app = new GildedRose(items);
        app.update();

        assertThat(app.items[0].quality).isEqualTo(36);
    }
}