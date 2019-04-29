package com.gildedrose.item;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ConjuredTest {

    @Parameters({"2,10,8", "0,10,6", "2,1,0"})
    @Test
    public void conjured_item_degrades_twice_faster(int sellIn, int quality, int qualityExpected) {
        Item[] items = new Item[]{new Item(ItemFactory.CONJURED_MANA_CAKE, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.update();

        assertThat(app.items[0].quality).isEqualTo(qualityExpected);
    }
}