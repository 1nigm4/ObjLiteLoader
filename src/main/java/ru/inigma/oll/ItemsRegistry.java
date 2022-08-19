package ru.inigma.oll;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.*;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.inigma.oll.item.MissleLauncher;

@ObjectHolder(ObjLiteLoader.MODID)
@EventBusSubscriber
public class ItemsRegistry {
    public static Item
        missleLauncher;

    public static Item[] ITEMS;

    @SubscribeEvent
    public static void onRegistryItems(Register<Item> e){
        ITEMS = new Item[]{
            missleLauncher = new MissleLauncher("missle_launcher")
        };
        e.getRegistry().registerAll(ITEMS);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onRegistryModels(ModelRegistryEvent e){
        for (Item item : ITEMS) {
            ResourceLocation registryName = item.getRegistryName();
            ModelResourceLocation modelResourceLocation = new ModelResourceLocation(registryName, "inventory");
            ModelBakery.registerItemVariants(item, modelResourceLocation);
            ModelLoader.setCustomModelResourceLocation(item, 0, modelResourceLocation);
        }
    }
}
