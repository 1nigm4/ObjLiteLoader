package ru.inigma.oll.item;

import net.minecraft.item.ItemBow;
import ru.inigma.oll.ObjLiteLoader;

public class MissleLauncher extends ItemBow {
    public MissleLauncher(String name){
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(ObjLiteLoader.creativeTab);
    }
}
