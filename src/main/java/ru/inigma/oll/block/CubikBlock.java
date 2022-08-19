package ru.inigma.oll.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import ru.inigma.oll.ObjLiteLoader;

public class CubikBlock extends Block {
    public CubikBlock(String name) {
        super(Material.ROCK);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(ObjLiteLoader.creativeTab);
    }
}
