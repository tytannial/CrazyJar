package CrazyJar.proxy;

import CrazyJar.lib.RenderIds;
import CrazyJar.render.block.*;
import CrazyJar.render.tiles.*;
import CrazyJar.storage.*;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * Created by yuany on 2016/6/29.
 */
public class ClientProxy extends CommonProxy {
    public void initSounds() {
        //TODO: No Use for now!
    }

    public void initRenderers() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEssentiaJar.class, new TileEssentiaJarRenderer());
        RenderIds.idEssentiaJar1 = RenderingRegistry.getNextAvailableRenderId();

        RenderingRegistry.registerBlockHandler(new BlockEssentiaJarRenderer(0));
        RenderingRegistry.registerBlockHandler(new BlockEssentiaJarRenderer(1));
        RenderingRegistry.registerBlockHandler(new BlockEssentiaJarRenderer(2));
        RenderingRegistry.registerBlockHandler(new BlockEssentiaJarRenderer(3));
        RenderingRegistry.registerBlockHandler(new BlockEssentiaJarRenderer(4));
    }
}
