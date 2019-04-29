package com.gildedrose.item;

import java.util.List;
import java.util.Objects;

public class WrappedItems {
    private List<WrappedItem> wrappedItems;

    public WrappedItems(List<WrappedItem> wrappedItems) {
        this.wrappedItems = wrappedItems;
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
