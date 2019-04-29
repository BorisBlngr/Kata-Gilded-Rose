package com.gildedrose;

import com.gildedrose.item.ItemFactory;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class GildedRoseTest {

    @Parameters({"0,0", "0,1", "1,1"})
    @Test
    public void item_quality_should_never_be_negative(int sellIn, int quality) {
        Item[] items = new Item[]{new Item("foo", sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.update();

        assertThat(app.items[0].quality).isGreaterThanOrEqualTo(0);
    }

    @Test
    public void item_quality_should_never_be_greater_that_50_unless_it_is_legendary() {
        Item[] items = new Item[]{new Item(ItemFactory.AGED_BRIE, 2, 50)};
        GildedRose app = new GildedRose(items);
        app.update();

        assertThat(app.items[0].quality).isEqualTo(50);
    }

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

    @Test
    public void brie_increase_by_1_when_sellIn_is_positive() {
        Item[] items = new Item[]{new Item(ItemFactory.AGED_BRIE, 2, 34)};
        GildedRose app = new GildedRose(items);
        app.update();

        assertThat(app.items[0].quality).isEqualTo(35);
    }

    @Test
    public void brie_increase_by_2_when_sellIn_is_strict_negative() {
        Item[] items = new Item[]{new Item(ItemFactory.AGED_BRIE, 0, 34)};
        GildedRose app = new GildedRose(items);
        app.update();

        assertThat(app.items[0].quality).isEqualTo(36);
    }

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

    @Parameters({"2,10,8", "0,10,6", "2,1,0"})
    @Test
    public void conjured_item_degrades_twice_faster(int sellIn, int quality, int qualityExpected) {
        Item[] items = new Item[]{new Item(ItemFactory.CONJURED_MANA_CAKE, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.update();

        assertThat(app.items[0].quality).isEqualTo(qualityExpected);
    }

}
