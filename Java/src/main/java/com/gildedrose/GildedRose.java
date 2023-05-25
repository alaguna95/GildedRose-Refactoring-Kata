package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private static final String AGED_BRIE_ITEM_NAME = "Aged Brie";
    private static final String BACKSTAGE_PASSES_ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_ITEM_NAME = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED_ITEM_NAME = "Conjured";
    private static final int MAX_QUALITY_VALUE = 50;
    private static final int MIN_QUALITY_VALUE = 0;

    private static final int SELL_IN_LIMIT_DAYS_MIN = 0;
    private static final int SELL_IN_LIMIT_DAYS_MEDIUM = 5;
    private static final int SELL_IN_LIMIT_DAYS_MAX = 10;


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
                case CONJURED_ITEM_NAME:
                    updateConjuredItem(item);
                    break;
                default:
                    updateNormalItem(item);
                    break;
            }
        }
    }

    private void updateAgedBrieItem(Item item){
        item.sellIn = item.sellIn-1;

        if(item.sellIn >= SELL_IN_LIMIT_DAYS_MIN){
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

        if(item.sellIn >= SELL_IN_LIMIT_DAYS_MAX){
            item.quality = item.quality + 1;
        }else if(item.sellIn >= SELL_IN_LIMIT_DAYS_MEDIUM){
            item.quality = item.quality + 2;
        }else if(item.sellIn >= SELL_IN_LIMIT_DAYS_MIN){
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

        if(item.sellIn >= SELL_IN_LIMIT_DAYS_MIN){
            item.quality = item.quality - 1;
        }else {
            item.quality = item.quality - 2;
        }
        if(item.quality<MIN_QUALITY_VALUE){
            item.quality = MIN_QUALITY_VALUE;
        }
    }
    private void updateConjuredItem(Item item){
        item.sellIn = item.sellIn-1;

        if(item.sellIn >= SELL_IN_LIMIT_DAYS_MIN){
            item.quality = item.quality - 2;
        }else {
            item.quality = item.quality - 4;
        }
        if(item.quality<MIN_QUALITY_VALUE){
            item.quality = MIN_QUALITY_VALUE;
        }
    }
}
