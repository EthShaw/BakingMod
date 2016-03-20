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

import net.fishdog5000.bakingmod.handler.CommonProxy;
import net.fishdog5000.bakingmod.handler.ConfigManager;
import net.fishdog5000.bakingmod.items.BakingModItems;
import net.fishdog5000.bakingmod.main.BakingMod;
import net.fishdog5000.core.FishdogsCore;
import net.fishdog5000.core.basestuff.IBaseItem;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientProxy extends CommonProxy {
    private List<ModelRegistration> multimodelsreg = new ArrayList<ModelRegistration>();

    @Override
    public String[] getValidConfig() {
        return ArrayUtils.addAll(new String[] { ConfigManager.ConfigKeys.MIXING_SPOON_HD, ConfigManager.ConfigKeys.MILL_STONE_HD,
                        ConfigManager.ConfigKeys.COOKIE_DOUGH_HD, ConfigManager.ConfigKeys.COOKIE_DOUGH_CHUNK_HD,
                        ConfigManager.ConfigKeys.BUTTER_HD, ConfigManager.ConfigKeys.FLOUR_HD,
                        ConfigManager.ConfigKeys.BUTTERED_BREAD_HD, ConfigManager.ConfigKeys.BREAD_DOUGH_HD },
                super.getValidConfig());
    }

    @Override
    public String[] getValidRestartConfig() {
        return super.getValidRestartConfig();
    }

    @Override
    public void registerModel(IBaseItem item, String name, int metadata, String[] locations, String defaultloc) {
        multimodelsreg.add(new ModelRegistration(item, name, metadata, locations, defaultloc));
    }

    @Override
    public void registerModel(IBaseItem item, String name, String[] locations, String defaultloc) {
        registerModel(item, name, 0, locations, defaultloc);
    }

    @Override
    public void registerRenderers() {
        //ClientRegistry.bindTileEntitySpecialRenderer(TestTileEntity.class, new RenderBlockFoodWorktable());
    }

    @Override
    public void init() {
        super.init();

        for (ModelRegistration modelreg : multimodelsreg)
            modelreg.item.setMultiTexture(FishdogsCore.setItemMultitexture(modelreg.item, modelreg.name, BakingMod.MODID, modelreg.locations, modelreg.defaultloc));
        multimodelsreg = null;
    }

    @Override
    public void reloadMultiTextures() {
        BakingModItems.reloadTextures();
    }

    private class ModelRegistration {
        final IBaseItem item;
        final String name;
        final String defaultloc;
        final String[] locations;
        final int metadata;

        ModelRegistration(IBaseItem _item, String _name, int _metadata, String[] _locations, String _defaultloc) {
            item = _item;
            name = _name;
            metadata = _metadata;
            locations = _locations;
            defaultloc = _defaultloc;
        }
    }
}
