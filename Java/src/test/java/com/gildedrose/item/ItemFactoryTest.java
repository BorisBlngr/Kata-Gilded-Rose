package com.gildedrose.item;

import com.gildedrose.Item;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemFactoryTest {

    @Test
    public void itemMustBeCommon() {
        Item item = new Item("FooBar", 1, 12);
        WrappedItem wrappedItem = ItemFactory.buildFrom(item);

        assertThat(wrappedItem).isInstanceOf(Common.class);
    }

    @Test
    public void itemMustBeLegendary() {
        Item item = new Item(ItemFactory.SULFURAS_HAND_OF_RAGNAROS, 1, 12);
        WrappedItem wrappedItem = ItemFactory.buildFrom(item);

        assertThat(wrappedItem).isInstanceOf(Legendary.class);
    }

    @Test
    public void itemMustBeConjured() {
        Item item = new Item(ItemFactory.CONJURED_MANA_CAKE, 1, 12);
        WrappedItem wrappedItem = ItemFactory.buildFrom(item);

        assertThat(wrappedItem).isInstanceOf(Conjured.class);
    }

    @Test
    public void itemMustBeAgedBrie() {
        Item item = new Item(ItemFactory.AGED_BRIE, 1, 12);
        WrappedItem wrappedItem = ItemFactory.buildFrom(item);

        assertThat(wrappedItem).isInstanceOf(AgedBrie.class);
    }

    @Test
    public void itemMustBeBackstagePass() {
        Item item = new Item(ItemFactory.BACKSTAGE_PASSES, 1, 12);
        WrappedItem wrappedItem = ItemFactory.buildFrom(item);

        assertThat(wrappedItem).isInstanceOf(BackstagePass.class);
    }
}