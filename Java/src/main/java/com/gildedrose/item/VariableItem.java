package com.gildedrose.item;

import com.gildedrose.Item;

abstract class VariableItem extends WrappedItem {

    protected final static int QUALITY_MAX = 50;

    VariableItem(Item item) {
        super(item);
    }


}
