package CrazyJar.storage;

import net.minecraftforge.common.util.ForgeDirection;
import thaumcraft.api.aspects.IAspectSource;
import thaumcraft.api.aspects.IEssentiaTransport;
import thaumcraft.common.tiles.TileJarFillable;

public class TileEssentiaJar extends TileJarFillable implements IAspectSource, IEssentiaTransport {

    public int[] max = {128,256,512,1024,2048};

    public int type=0;

    public TileEssentiaJar(int type) {
        this.maxAmount = this.max[type];
    }

    @Override
    public int getMinimumSuction() {
        return this.aspectFilter != null ? 56 + (amount / 50) : 48 + (amount / 50);
    }

    @Override
    public int getSuctionAmount(ForgeDirection loc) {
        if (this.amount < this.maxAmount) {
            if (this.aspectFilter != null) {
                return 56 + (amount / 50);
            }
            return 48 + (amount / 50);
        }
        return 0;
    }
}
