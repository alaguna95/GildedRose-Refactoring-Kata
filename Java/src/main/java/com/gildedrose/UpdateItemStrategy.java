package com.gildedrose;

public interface UpdateItemStrategy {
    int MAX_QUALITY_VALUE = 50;
    int MIN_QUALITY_VALUE = 0;
    void update(Item item);
}
