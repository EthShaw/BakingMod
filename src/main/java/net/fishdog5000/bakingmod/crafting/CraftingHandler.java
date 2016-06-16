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
import net.fishdog5000.bakingmod.main.BakingMod;
import net.fishdog5000.core.basestuff.DurabilityItemCrafting;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class CraftingHandler {

    /**
     * Register shaped crafting recipes.
     */
    public static void registerShapedCraftingRecipes() {
        ItemStack millstone_stack = new ItemStack(BakingModItems.millstone, 1, OreDictionary.WILDCARD_VALUE);

        BakingMod.logger.info("replacing recipes...");
        GameRegistry.addRecipe(new DurabilityItemCrafting(new ShapedOreRecipe(new ItemStack(Blocks.COBBLESTONE, 3),
                "***", "###",
                '*', millstone_stack.copy(), '#', "stone")));

        GameRegistry.addRecipe(new DurabilityItemCrafting(new ShapedOreRecipe(new ItemStack(Blocks.SAND, 3),
                "***", "###",
                '*', millstone_stack.copy(), '#', Blocks.GRAVEL)));

        GameRegistry.addRecipe(new DurabilityItemCrafting(new ShapedOreRecipe(new ItemStack(Blocks.GRAVEL, 3),
                "***", "###",
                '*', millstone_stack.copy(), '#', "cobblestone")));

        GameRegistry.addRecipe(new DurabilityItemCrafting(new ShapedOreRecipe(new ItemStack(BakingModItems.flour, 2),
                " # ", "XXX", "XXX",
                'X', "cropWheat", '#', millstone_stack.copy())));

        GameRegistry.addRecipe(new DurabilityItemCrafting(new ShapedOreRecipe(new ItemStack(BakingModItems.flour),
                " # ", "XXX",
                'X', "cropWheat", '#', millstone_stack)));

        GameRegistry.addRecipe(new DurabilityItemCrafting(new ShapedOreRecipe(new ItemStack(BakingModItems.mixing_spoon),
                "*", "E", "E",
                '*', "bowlWood", 'E', "stickWood")));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BakingModItems.cake_batter_unmixed),
                "AAA", "BEB", " C ",
                'A', "listAllmilk", 'B', "itemSugar", 'C', "foodFlour", 'E', "listAllegg"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BakingModItems.cookie_dough_blob),
                "XXX", "#E#", "O*T",
                'X', "dyeBrown", 'E', "listAllwater", '#', "foodFlour", '*', "itemSugar", 'O', "listAllegg", 'T', "foodButter"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BakingModItems.bread_sammich),
                "X", "X", "X",
                'X', "foodBread"));
    }

    /**
     * Register shapeless crafting recipes.
     */
    public static void registerShapelessCraftingRecipes() {
        ItemStack mixing_spoon_stack = new ItemStack(BakingModItems.mixing_spoon, 1, OreDictionary.WILDCARD_VALUE);

        GameRegistry.addRecipe(new DurabilityItemCrafting(new ShapelessOreRecipe(new ItemStack(BakingModItems.cookie_dough, 24),
                "foodCookieDoughBlob", mixing_spoon_stack.copy())));
        GameRegistry.addRecipe(new DurabilityItemCrafting(new ShapelessOreRecipe(new ItemStack(BakingModItems.pumpkin_pie_mixture),
                Items.SUGAR, "listAllegg", new ItemStack(Blocks.PUMPKIN), mixing_spoon_stack.copy())));
        GameRegistry.addRecipe(new DurabilityItemCrafting(new ShapelessOreRecipe(new ItemStack(BakingModItems.cake_batter),
                "foodUnmixedCakeBatter", mixing_spoon_stack.copy())));
        GameRegistry.addRecipe(new DurabilityItemCrafting(new ShapelessOreRecipe(new ItemStack(BakingModItems.millstone),
                "cobblestone", "cobblestone", "cobblestone")));
        GameRegistry.addRecipe(new DurabilityItemCrafting(new ShapelessOreRecipe(new ItemStack(BakingModItems.butter, 3),
                "listAllmilk", mixing_spoon_stack.copy()), 8));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(BakingModItems.buttered_bread), Items.BREAD, "foodButter"));
        GameRegistry.addRecipe(new DurabilityItemCrafting(new ShapelessOreRecipe(new ItemStack(BakingModItems.bread_dough, 5),
                "listAllwater", mixing_spoon_stack.copy(), "foodFlour", "foodFlour", "foodFlour", "foodFlour", "foodFlour")));
        GameRegistry.addRecipe(new DurabilityItemCrafting(new ShapelessOreRecipe(new ItemStack(BakingModItems.bread_dough, 4),
                "listAllwater", mixing_spoon_stack.copy(), "foodFlour", "foodFlour", "foodFlour", "foodFlour")));
        GameRegistry.addRecipe(new DurabilityItemCrafting(new ShapelessOreRecipe(new ItemStack(BakingModItems.bread_dough, 3),
                "listAllwater", mixing_spoon_stack.copy(), "foodFlour", "foodFlour", "foodFlour")));
        GameRegistry.addRecipe(new DurabilityItemCrafting(new ShapelessOreRecipe(new ItemStack(BakingModItems.bread_dough, 2),
                "listAllwater", mixing_spoon_stack.copy(), "foodFlour", "foodFlour")));
        GameRegistry.addRecipe(new DurabilityItemCrafting(new ShapelessOreRecipe(new ItemStack(BakingModItems.bread_dough),
                "listAllwater", mixing_spoon_stack, "foodFlour")));//todo multi-item crafting like with flour and mixing spoon and bread
    }

    /**
     * Register smelting recipes.
     */
    public static void registerSmeltingRecipes() {
        GameRegistry.addSmelting(BakingModItems.bread_dough, new ItemStack(Items.BREAD), 0.5F);
        GameRegistry.addSmelting(BakingModItems.cake_batter, new ItemStack(Items.CAKE), 0.5F);
        GameRegistry.addSmelting(BakingModItems.pumpkin_pie_mixture, new ItemStack(Items.PUMPKIN_PIE), 0.5F);
        GameRegistry.addSmelting(BakingModItems.cookie_dough, new ItemStack(Items.COOKIE), 0.1F);
    }
}
