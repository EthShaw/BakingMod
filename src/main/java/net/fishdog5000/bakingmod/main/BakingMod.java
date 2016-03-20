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
package net.fishdog5000.bakingmod.main;

import net.fishdog5000.bakingmod.crafting.CraftingHandler;
import net.fishdog5000.bakingmod.crafting.OreDictionaryHandler;
import net.fishdog5000.bakingmod.handler.BakingEventHandler;
import net.fishdog5000.bakingmod.handler.CommonProxy;
import net.fishdog5000.bakingmod.handler.ConfigManager;
import net.fishdog5000.bakingmod.items.BakingModItems;
import net.fishdog5000.core.FishdogsCore;
import net.minecraft.init.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;

//@formatter:off
@Mod(modid = BakingMod.MODID, name = BakingMod.NAME, acceptedMinecraftVersions = "", guiFactory = "net.fishdog5000.bakingmod.client.GuiFactory", version = BakingMod.VERSION)//@DEPEND@//(dependencies="required-after:fishdog5000score@[@COREVERSION@,)")
//@formatter:on
public class BakingMod {
    public static final String MODID = "fishdogsbakingmod",
            NAME = "Fishdog5000's Baking Mod",
            MCVERSION = "@MCVERSION@",
            VERSION = "@VERSION@";
            //VERSIONS_URL = "http://pastebin.com/raw.php?i=Qfa74bZe";

    public static Logger logger;

    @Instance(MODID)
    public static BakingMod INSTANCE;

    public static ConfigManager BAKING_CONFIGURATION;

    @SidedProxy(clientSide = "net.fishdog5000.bakingmod.client.ClientProxy", serverSide = "net.fishdog5000.bakingmod.handler.CommonProxy", modId = MODID)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("##################Baking mod starting!##################");
        logger.info("loading/preparing configuration file...");
        BAKING_CONFIGURATION = new ConfigManager();
        BAKING_CONFIGURATION.init(event);
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
        //logger.info("attempting to add version checker support...");
        //FMLInterModComms.sendRuntimeMessage(MODID, "VersionChecker", "addVersionCheck", VERSIONS_URL);
        logger.info("generating new items...");
        BakingModItems.init();

        logger.info("Adding items to Ore Dictionary...");
        OreDictionaryHandler.registerItemOres();

        logger.info("Adding recipes...");
        CraftingHandler.registerShapedCraftingRecipes();
        CraftingHandler.registerShapelessCraftingRecipes();
        CraftingHandler.registerSmeltingRecipes();
        BakingModItems.addDisaster();

        logger.info("Correcting achievements to work with new recipes...");
        MinecraftForge.EVENT_BUS.register(new BakingEventHandler());

        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        if (!ConfigManager.defaultCraftCake)
            FishdogsCore.removeRecipe(Items.cake);
        if (!ConfigManager.defaultCraftBread)
            FishdogsCore.removeRecipe(Items.bread);
        if (!ConfigManager.defaultCraftPumpkinPie)
            FishdogsCore.removeRecipe(Items.pumpkin_pie);
        if (!ConfigManager.defaultCraftCookies)
            FishdogsCore.removeRecipe(Items.cookie);

        logger.info("##################Baking mod ready!##################");
    }
}
