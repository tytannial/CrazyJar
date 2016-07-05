package CrazyJar.lib;

import CrazyJar.CrazyJarMain;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabTM extends CreativeTabs {

    public CreativeTabTM(int id, String tabLabel) {
        super(id, tabLabel);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public String getTabLabel() {
        return "CrazyJar";
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack getIconItemStack() {
        if (CrazyJarMain.itemMaterial != null) {
            return new ItemStack(CrazyJarMain.itemMaterial);
        }
        return super.getIconItemStack();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(Blocks.stone);
    }
}