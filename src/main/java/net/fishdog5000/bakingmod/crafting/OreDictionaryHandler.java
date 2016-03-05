/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 FishDog5000
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.fishdog5000.bakingmod.crafting;

import net.fishdog5000.bakingmod.items.BakingModItems;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHandler {

	public static void registerItemOres() {
		OreDictionary.registerOre("foodButter", BakingModItems.butter);
		OreDictionary.registerOre("foodCookieDough", BakingModItems.cookie_dough);
		OreDictionary.registerOre("foodDough", BakingModItems.bread_dough);
		OreDictionary.registerOre("foodBreadDough", BakingModItems.bread_dough);
		OreDictionary.registerOre("foodFlour", BakingModItems.flour);
		OreDictionary.registerOre("foodUnmixedCakeBatter", BakingModItems.cake_batter_unmixed);
		OreDictionary.registerOre("foodCakeBatter", BakingModItems.cake_batter);
		OreDictionary.registerOre("foodPumpkinPieMix", BakingModItems.pumpkin_pie_mixture);
		OreDictionary.registerOre("foodDisaster", BakingModItems.disaster);
		OreDictionary.registerOre("foodCookieDoughBlob", BakingModItems.cookie_dough_blob);
		OreDictionary.registerOre("foodButteredBread", BakingModItems.buttered_bread);
		OreDictionary.registerOre("foodBreadSandwich", BakingModItems.bread_sammich);
	}

	public static void registerBlockOres() {

	}
}
