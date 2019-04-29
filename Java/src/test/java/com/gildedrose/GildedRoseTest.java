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
    public void item_decrease_in_sellIn() {
        Item[] items = new Item[]{new Item("foo", 2, 49)};
        GildedRose app = new GildedRose(items);
        app.update();

        assertThat(app.items[0].sellIn).isEqualTo(1);
    }



}
