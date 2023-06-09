package com.gildedrose;

public enum UpdateItemStrategiesEnum {
    AGED_BRIE_ITEM_NAME("Aged Brie",new UpdateAgedBrieItemStrategy()),
    BACKSTAGE_PASSES_ITEM_NAME("Backstage passes to a TAFKAL80ETC concert",new UpdateBackstagePassesItemStrategy()),
    SULFURAS_ITEM_NAME("Sulfuras, Hand of Ragnaros",new UpdateSulfurasItemStrategy()),
    CONJURED_ITEM_NAME("Conjured",new UpdateConjuredItemStrategy());

    private final String itemType;
    private final UpdateItemStrategy updateItemStrategy;
    UpdateItemStrategiesEnum(String itemType, UpdateItemStrategy updateItemStrategy) {
        this.itemType = itemType;
        this.updateItemStrategy = updateItemStrategy;
    }

    public UpdateItemStrategy getUpdateItemStrategy() {
        return updateItemStrategy;
    }

    public static UpdateItemStrategy getUpdateItemStrategyByItemType(String itemType){
        UpdateItemStrategiesEnum updateItemStrategyEnum = UpdateItemStrategiesEnum.getUpdateItemStrategiesEnumByItemType(itemType);
        return updateItemStrategyEnum==null ? new UpdateNormalItemStrategy() : updateItemStrategyEnum.getUpdateItemStrategy();
    }

    private static UpdateItemStrategiesEnum getUpdateItemStrategiesEnumByItemType (String itemType){
        for(UpdateItemStrategiesEnum updateItemStrategyEnum: UpdateItemStrategiesEnum.values()){
            if(updateItemStrategyEnum.itemType.equals(itemType)){
                return updateItemStrategyEnum;
            }
        }
        return null;
    }
}
