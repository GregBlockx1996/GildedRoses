package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    public void qualityOfAnItemCanNotBeNegative() {
        Item[] items = new Item[] { new Item("foo", 1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void lowersTheQualityByOneWhenSellInLowers() {
        Item[] items = new Item[] { new Item("foo", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void agedBrieIncreasesByQualityWhenTheSellInApproaches() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }

    @Test
    public void theQualityOfAnItemCanNotBeMoreThan50() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void theQualityOfSulfurasNeverChanges() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 3, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void backstagePassesIncreaseInQualityWhenWhenTheSellInApproaches() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 23, 11) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    public void backstagePassesIncreasesQualityBy2WhenTheSellInIs10DaysOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 11) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
    }

    @Test
    public void backstagePassesIncreasesQualityBy3WhenTheSellInIs5DaysOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 2, 11) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items[0].quality);
    }

    @Test
    public void theQualityOfBackstagePassesBecomes0WhenTheSellInIs0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 11) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void onceTheSellDateHasPassedTheQualityLowersTwiceAsFast() {
        Item[] items = new Item[] { new Item("foo", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    // Conjured tests:
    @Test
    public void lowersTheQualityByTwoWhenSellInLowersAndTheItemIsConjured() {
        Item[] items = new Item[] { new Item("Conjured testing", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void conjuredAgedBrieIncreasesByTwoInQualityWhenTheSellInApproaches() {
        Item[] items = new Item[] { new Item("Conjured Aged Brie", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].quality);
    }

    @Test
    public void conjuredBackstagePassesIncreasesByTwoInQualityWhenWhenTheSellInApproaches() {
        Item[] items = new Item[] { new Item("Conjured Backstage passes to a TAFKAL80ETC concert", 23, 11) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
    }

    @Test
    public void conjuredBackstagePassesIncreasesByFourInQualityWhenTheSellInIsTenDaysOrLess() {
        Item[] items = new Item[] { new Item("Conjured Backstage passes to a TAFKAL80ETC concert", 9, 11) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(15, app.items[0].quality);
    }

    @Test
    public void conjuredBackstagePassesIncreasesBySixInQualityWhenTheSellInIsFiveDaysOrLess() {
        Item[] items = new Item[] { new Item("Conjured Backstage passes to a TAFKAL80ETC concert", 2, 11) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(17, app.items[0].quality);
    }

    @Test
    public void onceTheSellDateOfAConjuredItemHasPassedTheQualityLowersTwiceAsFast() {
        Item[] items = new Item[] { new Item("Conjured foo", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }
}
