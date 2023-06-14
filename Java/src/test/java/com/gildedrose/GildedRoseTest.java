package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    //https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/main/GildedRoseRequirements.txt

    @Test
    void update_normal_item(){
        Item itemExpected = new ItemBuilder().withName("Normal").withSellIn(1).withQuality(21).build();
        Item item = new ItemBuilder().withName("Normal").withSellIn(2).withQuality(22).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_normal_item_when_sell_days_have_passed(){
        Item itemExpected = new ItemBuilder().withName("Normal").withSellIn(-3).withQuality(10).build();
        Item item = new ItemBuilder().withName("Normal").withSellIn(-2).withQuality(12).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_normal_item_when_quality_has_the_min_quality_value(){
        Item itemExpected = new ItemBuilder().withName("Normal").withSellIn(-3).withQuality(0).build();
        Item item = new ItemBuilder().withName("Normal").withSellIn(-2).withQuality(0).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_normal_item_when_sell_days_have_passed_and_has_the_min_quality_value(){
        Item itemExpected = new ItemBuilder().withName("Normal").withSellIn(-3).withQuality(0).build();
        Item item = new ItemBuilder().withName("Normal").withSellIn(-2).withQuality(0).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_normal_item_when_sell_days_have_passed_and_has_the_min_quality_value_plus_one(){
        Item itemExpected = new ItemBuilder().withName("Normal").withSellIn(-3).withQuality(0).build();
        Item item = new ItemBuilder().withName("Normal").withSellIn(-2).withQuality(1).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }

    @Test
    void update_aged_brie_item(){
        Item itemExpected = new ItemBuilder().withName("Aged Brie").withSellIn(1).withQuality(23).build();
        Item item = new ItemBuilder().withName("Aged Brie").withSellIn(2).withQuality(22).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_aged_brie_item_when_sell_days_have_passed(){
        Item itemExpected = new ItemBuilder().withName("Aged Brie").withSellIn(-3).withQuality(24).build();
        Item item = new ItemBuilder().withName("Aged Brie").withSellIn(-2).withQuality(22).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_aged_brie_item_when_has_max_quality_value(){
        Item itemExpected = new ItemBuilder().withName("Aged Brie").withSellIn(1).withQuality(50).build();
        Item item = new ItemBuilder().withName("Aged Brie").withSellIn(2).withQuality(50).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_aged_brie_item_when_sell_days_have_passed_and_has_max_quality_value(){
        Item itemExpected = new ItemBuilder().withName("Aged Brie").withSellIn(-3).withQuality(50).build();
        Item item = new ItemBuilder().withName("Aged Brie").withSellIn(-2).withQuality(50).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_aged_brie_item_when_sell_days_have_passed_and_has_max_quality_value_minus_one(){
        Item itemExpected = new ItemBuilder().withName("Aged Brie").withSellIn(-3).withQuality(50).build();
        Item item = new ItemBuilder().withName("Aged Brie").withSellIn(-2).withQuality(49).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_sulfuras_item(){
        Item itemExpected = new ItemBuilder().withName("Sulfuras, Hand of Ragnaros").withSellIn(2).withQuality(80).build();
        Item item = new ItemBuilder().withName("Sulfuras, Hand of Ragnaros").withSellIn(2).withQuality(80).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_backstage_passes_item_when_expiration_days_are_higher_10(){
        Item itemExpected = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(10).withQuality(33).build();
        Item item = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(11).withQuality(32).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_backstage_passes_item_when_expiration_days_are_higher_10_and_has_max_quality_value(){
        Item itemExpected = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(20).withQuality(50).build();
        Item item = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(21).withQuality(50).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_backstage_passes_item_when_expiration_days_are_10(){
        Item itemExpected = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(9).withQuality(46).build();
        Item item = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(10).withQuality(44).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_backstage_passes_item_when_expiration_days_are_10_and_has_max_quality_value(){
        Item itemExpected = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(9).withQuality(50).build();
        Item item = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(10).withQuality(50).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_backstage_passes_item_when_expiration_days_are_10_and_has_max_quality_value_minus_one(){
        Item itemExpected = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(9).withQuality(50).build();
        Item item = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(10).withQuality(49).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_backstage_passes_item_when_expiration_days_are_higher_5(){
        Item itemExpected = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(5).withQuality(8).build();
        Item item = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(6).withQuality(6).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
   @Test
    void update_backstage_passes_item_when_expiration_days_are_5(){
        Item itemExpected = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(4).withQuality(44).build();
        Item item = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(5).withQuality(41).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

       assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_backstage_passes_item_when_expiration_days_are_5_and_has_max_quality_value(){
        Item itemExpected = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(4).withQuality(50).build();
        Item item = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(5).withQuality(50).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_backstage_passes_item_when_expiration_days_are_5_and_has_max_quality_value_minus_one(){
        Item itemExpected = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(4).withQuality(50).build();
        Item item = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(5).withQuality(49).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_backstage_passes_item_when_expiration_days_are_5_and_has_max_quality_value_minus_two(){
        Item itemExpected = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(4).withQuality(50).build();
        Item item = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(5).withQuality(48).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_backstage_passes_item_when_expiration_days_are_higher_0(){
        Item itemExpected = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(0).withQuality(34).build();
        Item item = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(1).withQuality(31).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_backstage_passes_item_when_expiration_days_are_negative(){
        Item itemExpected = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(-1).withQuality(0).build();
        Item item = new ItemBuilder().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(0).withQuality(31).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_conjured_item(){
        Item itemExpected = new ItemBuilder().withName("Conjured").withSellIn(1).withQuality(20).build();
        Item item = new ItemBuilder().withName("Conjured").withSellIn(2).withQuality(22).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_conjured_item_when_sell_days_have_passed(){
        Item itemExpected = new ItemBuilder().withName("Conjured").withSellIn(-3).withQuality(8).build();
        Item item = new ItemBuilder().withName("Conjured").withSellIn(-2).withQuality(12).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_conjured_item_when_quality_has_the_min_quality_value(){
        Item itemExpected = new ItemBuilder().withName("Conjured").withSellIn(-3).withQuality(0).build();
        Item item = new ItemBuilder().withName("Conjured").withSellIn(-2).withQuality(0).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_conjured_item_when_quality_has_the_min_quality_value_plus_one(){
        Item itemExpected = new ItemBuilder().withName("Conjured").withSellIn(-3).withQuality(0).build();
        Item item = new ItemBuilder().withName("Conjured").withSellIn(-2).withQuality(1).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_conjured_item_when_sell_days_have_passed_and_has_the_min_quality_value(){
        Item itemExpected = new ItemBuilder().withName("Conjured").withSellIn(-3).withQuality(0).build();
        Item item = new ItemBuilder().withName("Conjured").withSellIn(-2).withQuality(1).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_conjured_item_when_sell_days_have_passed_and_has_the_min_quality_value_plus_one(){
        Item itemExpected = new ItemBuilder().withName("Conjured").withSellIn(-3).withQuality(0).build();
        Item item = new ItemBuilder().withName("Conjured").withSellIn(-2).withQuality(1).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_conjured_item_when_sell_days_have_passed_and_has_the_min_quality_value_plus_two(){
        Item itemExpected = new ItemBuilder().withName("Conjured").withSellIn(-3).withQuality(0).build();
        Item item = new ItemBuilder().withName("Conjured").withSellIn(-2).withQuality(2).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
    @Test
    void update_conjured_item_when_sell_days_have_passed_and_has_the_min_quality_value_plus_three(){
        Item itemExpected = new ItemBuilder().withName("Conjured").withSellIn(-3).withQuality(0).build();
        Item item = new ItemBuilder().withName("Conjured").withSellIn(-2).withQuality(3).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item).usingRecursiveComparison().isEqualTo(itemExpected);
    }
}
