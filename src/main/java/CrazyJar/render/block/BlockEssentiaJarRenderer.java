package CrazyJar.render.block;

import CrazyJar.lib.Reference;
import CrazyJar.storage.*;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

public class BlockEssentiaJarRenderer implements ISimpleBlockRenderingHandler {

    private int BlockType;

    public BlockEssentiaJarRenderer(int type) {
        BlockType = type;
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
        GL11.glPushMatrix();
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        TileEssentiaJar te;
        switch (BlockType) {
            case 0: {
                te = new TileEssentiaJar1();
                break;
            }
            case 1: {
                te = new TileEssentiaJar2();
                break;
            }
            case 2: {
                te = new TileEssentiaJar3();
                break;
            }
            case 3: {
                te = new TileEssentiaJar4();
                break;
            }
            case 4: {
                te = new TileEssentiaJar5();
                break;
            }
            default: {
                te = new TileEssentiaJar1();
                break;
            }
        }
        TileEntityRendererDispatcher.instance.renderTileEntityAt(te, 0.0D, 0.0D, 0.0D, 0.0F);
        GL11.glPopMatrix();
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        return false;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    @Override
    public int getRenderId() {
        return Reference.idEssentiaJar;
    }

}
