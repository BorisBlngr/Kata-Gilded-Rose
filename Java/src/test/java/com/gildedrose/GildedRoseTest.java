package com.gildedrose;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseTest {

    @Test
    public void item_quality_should_never_be_negative() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality).isGreaterThanOrEqualTo(0);
    }

    @Test
    public void golden_master() throws IOException {
        List<String> result = new ArrayList<>();

        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);

        int days = 10;

        for (int i = 0; i < days; i++) {
            print("-------- day " + i + " --------", result);
            print("name, sellIn, quality", result);
            for (Item item : items) {
                print(item.toString(), result);
            }
            print("", result);
            app.updateQuality();
        }

        List<String> expected = Files.readAllLines(Paths.get("src/test/resources/goldenMaster.txt"));

        assertThat(result).containsExactlyElementsOf(expected);
    }

    private void print(String line, List<String> result) {
        result.add(line);
        System.out.println(line);
    }

}
