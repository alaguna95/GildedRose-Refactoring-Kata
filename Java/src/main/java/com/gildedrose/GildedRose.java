package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdateItemStrategiesEnum.getUpdateItemStrategyByItemType(item.name).update(item);
        }
    }
}
