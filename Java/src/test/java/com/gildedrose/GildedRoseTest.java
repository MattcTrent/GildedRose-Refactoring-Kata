package com.gildedrose;

import org.junit.jupiter.api.Test;
import static com.gildedrose.Constants.agedBrie;
import static com.gildedrose.Constants.backStagePass;
import static com.gildedrose.Constants.sulfurasName;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void AgedBrieTest() {
        Item[] items = new Item[] { 
            new Item(agedBrie, 2, 0), };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(agedBrie, app.items[0].name);
        assertEquals(1, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    void AgedBrie5DaysTest() {
        Item[] items = new Item[] { 
            new Item(agedBrie, 7, 0), };
        GildedRose app = new GildedRose(items);
        int days = 5;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(agedBrie, app.items[0].name);
        assertEquals(5, app.items[0].quality);
        assertEquals(2, app.items[0].sellIn);
    }
    

    @Test
    void AgedBrie5DaysExpiredTest() {
        Item[] items = new Item[] { 
            new Item(agedBrie, 4, 0), };
        GildedRose app = new GildedRose(items);
        int days = 5;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(agedBrie, app.items[0].name);
        assertEquals(6, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void BackStagePassLongLifeTest() {
        Item[] items = new Item[] { 
            new Item(backStagePass, 30, 10), };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(backStagePass, app.items[0].name);
        assertEquals(11, app.items[0].quality);
        assertEquals(29, app.items[0].sellIn);
    }

    @Test
    void BackStagePassMidLifeTest() {
        Item[] items = new Item[] { 
            new Item(backStagePass, 10, 10), };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(backStagePass, app.items[0].name);
        assertEquals(12, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void BackStagePassLowLifeTest() {
        Item[] items = new Item[] { 
            new Item(backStagePass, 5, 10), };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(backStagePass, app.items[0].name);
        assertEquals(13, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }
    

    @Test
    void BackStagePassLowLife5DaysTest() {
        Item[] items = new Item[] { 
            new Item(backStagePass, 14, 10), };
        GildedRose app = new GildedRose(items);
        int days = 5;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(backStagePass, app.items[0].name);
        assertEquals(16, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void BackStagePassExpiredTest() {
        Item[] items = new Item[] { 
            new Item(backStagePass, -1, 10), };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(backStagePass, app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }
    
    @Test
    void SulfurasTest() {
        Item[] items = new Item[] { 
            new Item(sulfurasName, 3, 10), };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(sulfurasName, app.items[0].name);
        assertEquals(10, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);
    }
        
    @Test
    void Sulfuras5DaysTest() {
        Item[] items = new Item[] { 
            new Item(sulfurasName, 3, 10), };
        GildedRose app = new GildedRose(items);
        int days = 5;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(sulfurasName, app.items[0].name);
        assertEquals(10, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);
    }
    
    @Test
    void ElixirTest() {
        Item[] items = new Item[] { 
            new Item("Elixir", 3, 10), };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Elixir", app.items[0].name);
        assertEquals(9, app.items[0].quality);
        assertEquals(2, app.items[0].sellIn);
    }

    @Test
    void Elixir5DayTest() {
        Item[] items = new Item[] { 
            new Item("Elixir", 6, 10), };
        GildedRose app = new GildedRose(items);
        int days = 5;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals("Elixir", app.items[0].name);
        assertEquals(5, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    void Elixir5DayExpireTest() {
        Item[] items = new Item[] { 
            new Item("Elixir", 3, 10), };
        GildedRose app = new GildedRose(items);
        int days = 5;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals("Elixir", app.items[0].name);
        assertEquals(3, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }
}
