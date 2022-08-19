package ru.inigma.oll;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.inigma.oll.block.CubikBlock;

@GameRegistry.ObjectHolder(ObjLiteLoader.MODID)
@Mod.EventBusSubscriber
public class BlocksRegistry {
    public static Block
        cubikBlock;

    public static Block[] BLOCKS;

    @SubscribeEvent
    public static void onRegistryBlocks(Register<Block> e){
        BLOCKS = new Block[]{
            cubikBlock = new CubikBlock("cubik_block")
        };

        for (Block block : BLOCKS) {
            Item itemBlock = new ItemBlock(block).setRegistryName(block.getRegistryName());
            e.getRegistry().register(block);
            ForgeRegistries.ITEMS.register(itemBlock);
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onRegistryModels(ModelRegistryEvent e){
        for (Block block : BLOCKS) {
            ResourceLocation registryName = block.getRegistryName();
            ModelResourceLocation modelResourceLocation = new ModelResourceLocation(registryName, "inventory");
            Item itemBlock = Item.getItemFromBlock(block);
            ModelBakery.registerItemVariants(itemBlock, modelResourceLocation);
            ModelLoader.setCustomModelResourceLocation(itemBlock, 0, modelResourceLocation);
        }
    }
}
