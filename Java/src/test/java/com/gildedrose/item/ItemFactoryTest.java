package com.gildedrose.item;

import com.gildedrose.Item;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemFactoryTest {

    @Test
    public void itemMustBeLegendary() {
        Item item = new Item(ItemFactory.SULFURAS_HAND_OF_RAGNAROS, 1, 12);
        WrappedItem wrappedItem = ItemFactory.buildFrom(item);

        assertThat(wrappedItem).isInstanceOf(LegendaryItem.class);
    }

    @Test
    public void itemMustBeConjured() {
        Item item = new Item(ItemFactory.CONJURED_MANA_CAKE, 1, 12);
        WrappedItem wrappedItem = ItemFactory.buildFrom(item);

        assertThat(wrappedItem).isInstanceOf(ConjuredItem.class);
    }

    @Test
    public void itemMustBeAgedBrie() {
        Item item = new Item(ItemFactory.AGED_BRIE, 1, 12);
        WrappedItem wrappedItem = ItemFactory.buildFrom(item);

        assertThat(wrappedItem).isInstanceOf(AgedBrieItem.class);
    }
}