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
package net.fishdog5000.bakingmod.handler;

import net.fishdog5000.bakingmod.main.BakingConstants;
import net.fishdog5000.bakingmod.main.BakingMod;
import net.fishdog5000.core.FishdogsCore;
import net.fishdog5000.core.basestuff.BaseConfig;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigManager extends BaseConfig {
    public static Configuration config;

    public static byte mixing_spoon_size,
            millstone_size,
            cookie_dough_size,
            cookie_dough_blob_size,
            butter_size,
            flour_size,
            buttered_bread_size,
            bread_dough_size;

    public static boolean defaultCraftCake,
            defaultCraftBread,
            defaultCraftCookies,
            defaultCraftPumpkinPie;

    private static boolean initilized = false;

    public ConfigManager() {
        super(BakingMod.logger);
    }

    public void preConfigure() {
        BakingMod.logger.info("reloading config...");
        validateCatagory(BakingMod.proxy.getValidConfig(), config, Configuration.CATEGORY_GENERAL);
        validateCatagory(BakingMod.proxy.getValidRestartConfig(), config, BakingConstants.CATAGORY_REQUIRE_RESTART);
    }

    public void configure() {
        preConfigure();

        String comment;
        String name;
        boolean bool;

        if (FishdogsCore.proxy().isClient()) {
            comment = I18n.translateToLocal(ConfigKeys.MIXING_SPOON_HD + ConfigKeys.COMMENT_EXTENTION);
            name = ConfigKeys.MIXING_SPOON_HD;
            bool = getConfigBool(name, comment, true);
            if (bool)
                mixing_spoon_size = 32;
            else
                mixing_spoon_size = 16;

            comment = I18n.translateToLocal(ConfigKeys.MILL_STONE_HD + ConfigKeys.COMMENT_EXTENTION);
            name = ConfigKeys.MILL_STONE_HD;
            bool = getConfigBool(name, comment, true);
            if (bool)
                millstone_size = 32;
            else
                millstone_size = 16;

            comment = I18n.translateToLocal(ConfigKeys.COOKIE_DOUGH_HD + ConfigKeys.COMMENT_EXTENTION);
            name = ConfigKeys.COOKIE_DOUGH_HD;
            bool = getConfigBool(name, comment, true);
            if (bool)
                cookie_dough_size = 32;
            else
                cookie_dough_size = 16;

            comment = I18n.translateToLocal(ConfigKeys.COOKIE_DOUGH_CHUNK_HD + ConfigKeys.COMMENT_EXTENTION);
            name = ConfigKeys.COOKIE_DOUGH_CHUNK_HD;
            bool = getConfigBool(name, comment, true);
            if (bool)
                cookie_dough_blob_size = 32;
            else
                cookie_dough_blob_size = 16;

            comment = I18n.translateToLocal(ConfigKeys.BUTTER_HD + ConfigKeys.COMMENT_EXTENTION);
            name = ConfigKeys.BUTTER_HD;
            bool = getConfigBool(name, comment, true);
            if (bool)
                butter_size = 32;
            else
                butter_size = 16;

            comment = I18n.translateToLocal(ConfigKeys.FLOUR_HD + ConfigKeys.COMMENT_EXTENTION);
            name = ConfigKeys.FLOUR_HD;
            bool = getConfigBool(name, comment, true);
            if (bool)
                flour_size = 32;
            else
                flour_size = 16;

            comment = I18n.translateToLocal(ConfigKeys.BUTTERED_BREAD_HD + ConfigKeys.COMMENT_EXTENTION);
            name = ConfigKeys.BUTTERED_BREAD_HD;
            bool = getConfigBool(name, comment, true);
            if (bool)
                buttered_bread_size = 32;
            else
                buttered_bread_size = 16;

            comment = I18n.translateToLocal(ConfigKeys.BREAD_DOUGH_HD + ConfigKeys.COMMENT_EXTENTION);
            name = ConfigKeys.BREAD_DOUGH_HD;
            bool = getConfigBool(name, comment, true);
            if (bool)
                bread_dough_size = 32;
            else
                bread_dough_size = 16;
        }

        config.getCategory(BakingConstants.CATAGORY_REQUIRE_RESTART).setRequiresMcRestart(true);

        comment = I18n.translateToLocal(ConfigKeys.CAKE_DEFAULT_CRAFTING_ALLOWED + ConfigKeys.COMMENT_EXTENTION);
        name = ConfigKeys.CAKE_DEFAULT_CRAFTING_ALLOWED;
        bool = getConfigBool(name, comment, false, BakingConstants.CATAGORY_REQUIRE_RESTART);
        defaultCraftCake = bool;

        comment = I18n.translateToLocal(ConfigKeys.BREAD_DEFAULT_CRAFTING_ALLOWED + ConfigKeys.COMMENT_EXTENTION);
        name = ConfigKeys.BREAD_DEFAULT_CRAFTING_ALLOWED;
        bool = getConfigBool(name, comment, false, BakingConstants.CATAGORY_REQUIRE_RESTART);
        defaultCraftBread = bool;

        comment = ConfigKeys.PUMPKIN_PIE_DEFAULT_CRAFTING_ALLOWED + ConfigKeys.COMMENT_EXTENTION;
        name = ConfigKeys.PUMPKIN_PIE_DEFAULT_CRAFTING_ALLOWED;
        bool = getConfigBool(name, comment, false, BakingConstants.CATAGORY_REQUIRE_RESTART);
        defaultCraftPumpkinPie = bool;

        comment = I18n.translateToLocal(ConfigKeys.COOKIE_DEFAULT_CRAFTING_ALLOWED + ConfigKeys.COMMENT_EXTENTION);
        name = ConfigKeys.COOKIE_DEFAULT_CRAFTING_ALLOWED;
        bool = getConfigBool(name, comment, false, BakingConstants.CATAGORY_REQUIRE_RESTART);
        defaultCraftPumpkinPie = bool;

        if (config.hasChanged())
            config.save();
        BakingMod.logger.info("Complete.");

        // updates stuff that needs to be reloaded with config
        if (initilized)
            postConfigure();
    }

    public void postConfigure() {
        BakingMod.proxy.reloadMultiTextures();
    }

    private boolean getConfigBool(String name, String comment, boolean defaultvalue) {
        return getConfigBool(name, comment, defaultvalue, config, Configuration.CATEGORY_GENERAL);
    }

    private boolean getConfigBool(String name, String comment, boolean defaultvalue, String catagory) {
        return super.getConfigBool(name, comment, defaultvalue, config, catagory);
    }

    public void init(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        configure();
        initilized = true;
    }

    public final class ConfigKeys {
        public static final String MIXING_SPOON_HD = "item.mixing_spoon.hdtextures",
                MILL_STONE_HD = "item.millstone.hdtextures",
                COOKIE_DOUGH_HD = "item.cookiedough.hdtextures",
                COOKIE_DOUGH_CHUNK_HD = "item.cookiedoughblob.hdtextures",
                BUTTER_HD = "item.butter.hdtextures",
                FLOUR_HD = "item.flour.hdtextures",
                BUTTERED_BREAD_HD = "item.buttered_bread.hdtextures",
                BREAD_DOUGH_HD = "item.breaddough.hdtextures",
                CAKE_DEFAULT_CRAFTING_ALLOWED = "item.cake.allowdefaultcrafting",
                BREAD_DEFAULT_CRAFTING_ALLOWED = "item.bread.allowdefaultcrafting",
                PUMPKIN_PIE_DEFAULT_CRAFTING_ALLOWED = "item.pumpkinpie.allowdefaultcrafting",
                COOKIE_DEFAULT_CRAFTING_ALLOWED = "item.cookies.allowdefaultcrafting",
                COMMENT_EXTENTION = ".comment";
    }

}
