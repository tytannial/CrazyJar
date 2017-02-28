package CrazyJar.block;

import CrazyJar.CrazyJarMain;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import org.lwjgl.input.Keyboard;
import thaumcraft.common.blocks.CustomStepSound;

import java.util.ArrayList;


public abstract class BlockContainerExpand extends BlockContainer {

    public TileEntity dummy;

    public BlockContainerExpand() {
        super(Material.iron);
        setStepSound(new CustomStepSound("jar", 1.0F, 1.0F));
        setCreativeTab(CrazyJarMain.tabsTM);
        setHardness(2.0F);
        this.dummy = createNewTileEntity(null, 0);
    }

    NBTTagCompound comp = new NBTTagCompound();

    @Override
    public void breakBlock(World w, int x, int y, int z, Block b, int meta) {
        TileEntity tile = w.getTileEntity(x, y, z);
        comp = new NBTTagCompound();
        if (tile != null) {
            tile.writeToNBT(comp);
            w.removeTileEntity(x, y, z);
        }
    }

    @Override
    public ArrayList<ItemStack> getDrops(World w, int x, int y, int z, int metadata, int fortune) {
        ItemStack drop = new ItemStack(this, 1, metadata);
        drop.stackTagCompound = (NBTTagCompound) comp.copy();
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        drops.add(drop);
        return drops;
    }

    @Override
    public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase player, ItemStack items) {
        if (items != null && items.hasTagCompound()) {
            items.stackTagCompound.setInteger("x", x);
            items.stackTagCompound.setInteger("y", y);
            items.stackTagCompound.setInteger("z", z);
            if (w.getTileEntity(x, y, z) != null) {
                w.getTileEntity(x, y, z).readFromNBT(items.stackTagCompound);
            }
        }
    }
}
