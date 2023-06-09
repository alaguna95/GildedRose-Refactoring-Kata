package com.gildedrose;

public class UpdateBackstagePassesItemStrategy implements UpdateItemStrategy{

    private static final int SELL_IN_LIMIT_DAYS_MIN = 0;
    private static final int SELL_IN_LIMIT_DAYS_MEDIUM = 5;
    private static final int SELL_IN_LIMIT_DAYS_MAX = 10;


    public void update(Item item){
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
}
