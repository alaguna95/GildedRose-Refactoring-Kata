package com.gildedrose;

public class UpdateNormalItemStrategy implements UpdateItemStrategy{

    private static final int SELL_IN_LIMIT_DAYS_MIN = 0;

    public void update(Item item){
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
}