package com.gildedrose;

import static com.gildedrose.Constants.agedBrie;
import static com.gildedrose.Constants.backStagePass;
import static com.gildedrose.Constants.sulfurasName;

class GildedRose {
    Item[] items;


    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) 
        {
            if (!item.name.equals(agedBrie) && !item.name.equals(backStagePass)) 
            {
                DecreaseQuality(item);
            } 
            else 
            {
                if (item.quality < 50) 
                {
                    item.quality += 1;

                    if (item.name.equals(backStagePass)) 
                    {
                        if (item.sellIn < 11) 
                        {
                            IncreaseQuality(item);
                        }

                        if (item.sellIn < 6) 
                        {
                            IncreaseQuality(item);
                        }
                    }
                }
            }

            ReduceSellIn(item);

            if (item.sellIn < 0) 
            {
                if (!item.name.equals(agedBrie)) 
                {
                    if (!item.name.equals(backStagePass)) 
                    {
                        DecreaseQuality(item);
                    } 
                    else 
                    {
                        item.quality = item.quality - item.quality;
                    }
                } 
                else 
                {
                    IncreaseQuality(item);
                }
            }
        }
    }

    private void ReduceSellIn(Item item)
    {
        if (!item.name.equals(sulfurasName)) 
        {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void IncreaseQuality(Item item)
    {
        if (item.quality < 50) 
        {
            item.quality += 1;
        }
    }

    private void DecreaseQuality(Item item)
    {
        if (item.quality > 0) 
        {
            if (!item.name.equals(sulfurasName)) 
            {
                item.quality -= 1;
            }
        }
    }
}