package ru.inigma.oll.proxy;

import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import ru.inigma.oll.manager.OllModelLoader;
import ru.inigma.oll.util.ResourceUtil;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        ModelLoaderRegistry.registerLoader(OllModelLoader.INSTANCE);
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        ResourceUtil.removeKey();
        super.postInit(event);
    }
}
