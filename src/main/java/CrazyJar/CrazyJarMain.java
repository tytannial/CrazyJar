package CrazyJar;

import CrazyJar.lib.CreativeTabTM;
import CrazyJar.lib.Reference;
import CrazyJar.proxy.CommonProxy;
import CrazyJar.register.Thaumcraft;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, dependencies = "after:Waila@[1.5.8,);after:Thaumcraft;")
public class CrazyJarMain {

    @Mod.Instance(Reference.MOD_ID)
    public static CrazyJarMain instance;

    public static Item itemMaterial;

    //Crative tab
    public static CreativeTabs tabsTM = new CreativeTabTM(CreativeTabs.getNextID(), Reference.MOD_ID);

    @SidedProxy(clientSide = Reference.proxy_loc + "ClientProxy", serverSide = Reference.proxy_loc + "CommonProxy")
    public static CommonProxy proxy;

    public static Logger logger;



    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        proxy.initRenderers();
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
        Thaumcraft.getInstance().RegisterMods();

        System.out.println("CrazyJar Initialization");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        RegisterRecipes();
    }


    public void RegisterRecipes() {
        //TODO: 注册合成公式
    }
}
