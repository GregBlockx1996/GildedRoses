package com.gildedrose;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	private int multiplier = 1;

	public void updateQuality() {

		for (Item item : items) {
			if (item.quality > 0 && item.quality < 50 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
				if (item.name.contains("Conjured")) {
					multiplier = 2;
				}

				if (!item.name.equals("Sulfuras, Hand of Ragnaros") && !item.name.contains("Aged Brie") && !item.name.contains("Backstage passes")) {
					item.quality = item.quality - multiplier;
				}

				if (item.sellIn <= 0) {
					item.quality = item.quality - (multiplier);
				}

				if (item.name.contains("Aged Brie")) {
					item.quality = item.quality + (multiplier);
				}

				if (item.name.contains("Backstage passes")) {
					if (item.sellIn <= 0) {
						item.quality = 0;
					} else if (item.sellIn <= 5) {
						item.quality = item.quality + (3 * multiplier);
					} else if (item.sellIn <= 10) {
						item.quality = item.quality + (2 * multiplier);
					} else {
						item.quality = item.quality + (multiplier);
					}
				}
			}
		}
	}
}
