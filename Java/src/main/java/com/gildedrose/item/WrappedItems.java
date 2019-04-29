package com.gildedrose.item;

import com.gildedrose.Item;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class WrappedItems {
    private List<WrappedItem> wrappedItems;

    private WrappedItems(Item... items) {
        wrappedItems = Arrays.stream(items)
                .map(ItemFactory::buildFrom)
                .collect(toList());
    }

    public static WrappedItems of(Item... items) {
        return new WrappedItems(items);
    }

    public void updateAll() {
        wrappedItems.forEach(WrappedItem::update);
    }

    @Override
    public String toString() {
        return "WrappedItems{" +
                "wrappedItems=" + wrappedItems +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrappedItems that = (WrappedItems) o;
        return Objects.equals(wrappedItems, that.wrappedItems);
    }

    @Override
    public int hashCode() {
        return wrappedItems != null ? wrappedItems.hashCode() : 0;
    }
}
