package ru.inigma.oll;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import ru.inigma.oll.proxy.CommonProxy;

@Mod(modid = ObjLiteLoader.MODID, version = ObjLiteLoader.VERSION, name = ObjLiteLoader.NAME)
public class ObjLiteLoader {
    public static final String MODID = "oll";
    public static final String VERSION = "1.0";
    public static final String NAME = "ObjLiteLoader";

    @SidedProxy(clientSide = "ru.inigma.oll.proxy.ClientProxy", serverSide = "ru.inigma.oll.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static final CreativeTabs creativeTab = new CreativeTabs(NAME) {
        @Override
        public ItemStack getTabIconItem() {
            return ItemsRegistry.missleLauncher.getDefaultInstance();
        }
    };

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
