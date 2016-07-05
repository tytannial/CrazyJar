package CrazyJar.register;

import CrazyJar.block.*;
import CrazyJar.lib.Names;
import CrazyJar.storage.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;

public class Thaumcraft {
    private static Thaumcraft instance;

    public static Item itemJarFilled;
    public static Item itemResource;
    public static Item itemEssence;

    public static Block blockJar;

    public static Block essentiaJar1;
    public static Block essentiaJar2;
    public static Block essentiaJar3;
    public static Block essentiaJar4;
    public static Block essentiaJar5;

    private Thaumcraft() {
    }

    public static Thaumcraft getInstance() {
        if (instance == null) {
            instance = new Thaumcraft();
        }
        return instance;
    }

    protected void _TileEntityRegister(Block block, Class<? extends TileEntity> teClass, String name) {
        if (block != null) {
            GameRegistry.registerTileEntity(teClass, name);
        }
    }

    public static void _BlockRegister(Block block, String name) {
        if (block != null) {
            GameRegistry.registerBlock(block, name);
        }
    }

    public void RegisterMods() {

        itemJarFilled = GameRegistry.findItem("Thaumcraft", "BlockJarFilledItem");
        itemResource = GameRegistry.findItem("Thaumcraft", "ItemResource");
        itemEssence = GameRegistry.findItem("Thaumcraft", "ItemEssence");
        blockJar = GameRegistry.findBlock("Thaumcraft", "blockJar");

        essentiaJar1 = new BlockEssentiaJar(0);
        essentiaJar2 = new BlockEssentiaJar(1);
        essentiaJar3 = new BlockEssentiaJar(2);
        essentiaJar4 = new BlockEssentiaJar(3);
        essentiaJar5 = new BlockEssentiaJar(4);

        _BlockRegister(essentiaJar1, Names.essentiaJar1);
        _BlockRegister(essentiaJar2, Names.essentiaJar2);
        _BlockRegister(essentiaJar3, Names.essentiaJar3);
        _BlockRegister(essentiaJar4, Names.essentiaJar4);
        _BlockRegister(essentiaJar5, Names.essentiaJar5);

        _TileEntityRegister(essentiaJar1, TileEssentiaJar.class, "TileEssentiaJar");
        _TileEntityRegister(essentiaJar2, TileEssentiaJar.class, "TileEssentiaJar2");
        _TileEntityRegister(essentiaJar3, TileEssentiaJar.class, "TileEssentiaJar3");
        _TileEntityRegister(essentiaJar4, TileEssentiaJar.class, "TileEssentiaJar4");
        _TileEntityRegister(essentiaJar5, TileEssentiaJar.class, "TileEssentiaJar5");
    }
}