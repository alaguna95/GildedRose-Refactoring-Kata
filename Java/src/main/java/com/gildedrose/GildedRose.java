package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private static final String AGED_BRIE_ITEM_NAME = "Aged Brie";
    private static final String BACKSTAGE_PASSES_ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_ITEM_NAME = "Sulfuras, Hand of Ragnaros";
    private static final int MAX_QUALITY_VALUE = 50;
    private static final int MIN_QUALITY_VALUE = 0;

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case AGED_BRIE_ITEM_NAME:
                    updateAgedBrieItem(item);
                    break;
                case BACKSTAGE_PASSES_ITEM_NAME:
                    updateBackstagePassesItem(item);
                    break;
                case SULFURAS_ITEM_NAME:
                    break;
                default:
                    updateNormalItem(item);
                    break;
            }
        }
    }



    private void updateAgedBrieItem(Item item){
        item.sellIn = item.sellIn-1;

        if(item.sellIn >= 0){
            item.quality = item.quality + 1;
        }else {
            item.quality = item.quality + 2;
        }
        if(item.quality>MAX_QUALITY_VALUE){
            item.quality = MAX_QUALITY_VALUE;
        }
    }

    private void updateBackstagePassesItem(Item item){
        item.sellIn = item.sellIn-1;

        if(item.sellIn >= 10){
            item.quality = item.quality + 1;
        }else if(item.sellIn >= 5){
            item.quality = item.quality + 2;
        }else if(item.sellIn >= 0){
            item.quality = item.quality + 3;
        }else{
            item.quality = 0;
        }
        if(item.quality>MAX_QUALITY_VALUE){
            item.quality = MAX_QUALITY_VALUE;
        }
    }

    private void updateNormalItem(Item item){
        item.sellIn = item.sellIn-1;

        if(item.sellIn >= 0){
            item.quality = item.quality - 1;
        }else {
            item.quality = item.quality - 2;
        }
        if(item.quality<MIN_QUALITY_VALUE){
            item.quality = MIN_QUALITY_VALUE;
        }
    }
}
