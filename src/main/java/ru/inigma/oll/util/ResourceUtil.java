package ru.inigma.oll.util;

import net.minecraft.client.resources.DefaultResourcePack;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.SimpleResource;
import net.minecraft.util.ResourceLocation;
import ru.inigma.oll.ObjLiteLoader;

import java.io.*;

public class ResourceUtil {
    private static int KEY;
    public static IResource derypt(IResource resource) throws IOException{
        try{
            ResourceLocation location = resource.getResourceLocation();
            String relativePath = "/assets/" + ObjLiteLoader.MODID + "/" + location.getResourcePath();
            String modelPath = DefaultResourcePack.class.getResource(relativePath).getFile();

            FileInputStream inputStream = new FileInputStream(modelPath);
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();

            for (int i = 0; i < data.length; i++){
                data[i] = (byte)(data[i] ^ KEY);
            }

            ByteArrayInputStream sr = new ByteArrayInputStream(data);
            return new SimpleResource(null, location, sr, null, null);

        }
        catch (Exception e){
            throw new IOException("Model not found!");
        }
    }

    public static void setKey(int key){
        KEY = key;
    }

    public static boolean existsKey(){
        return KEY != 0;
    }

    public static void removeKey(){
        KEY = 0;
    }
}
