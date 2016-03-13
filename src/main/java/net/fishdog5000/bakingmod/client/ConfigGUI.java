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
package net.fishdog5000.bakingmod.client;

import net.fishdog5000.bakingmod.handler.ConfigManager;
import net.fishdog5000.bakingmod.main.BakingConstants;
import net.fishdog5000.bakingmod.main.BakingMod;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.List;

public class ConfigGUI extends GuiConfig {
    public ConfigGUI(GuiScreen parent) {
        super(parent, getConfigElementList(), BakingMod.MODID, false, false, GuiConfig.getAbridgedConfigPath(ConfigManager.config.toString()));
    }

    private static List<IConfigElement> getConfigElementList() {
        List<IConfigElement> list = new ArrayList<IConfigElement>();
        list.add(new ConfigElement(ConfigManager.config.getCategory(Configuration.CATEGORY_GENERAL)));
        list.add(new ConfigElement(ConfigManager.config.getCategory(BakingConstants.CATAGORY_REQUIRE_RESTART)));
        return list;
    }
}
