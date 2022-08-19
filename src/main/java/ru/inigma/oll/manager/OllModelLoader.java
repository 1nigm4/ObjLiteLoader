package ru.inigma.oll.manager;

import net.minecraft.client.resources.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJModel;
import org.apache.commons.io.IOUtils;
import ru.inigma.oll.ObjLiteLoader;
import ru.inigma.oll.util.HttpUtil;
import ru.inigma.oll.util.ResourceUtil;

import java.io.FileNotFoundException;

public enum OllModelLoader implements ICustomModelLoader {
    INSTANCE;

    private IResourceManager manager;

    @Override
    public void onResourceManagerReload(IResourceManager resourceManager) {
        this.manager = resourceManager;
    }

    @Override
    public boolean accepts(ResourceLocation modelLocation) {
        return modelLocation.getResourceDomain().equals(ObjLiteLoader.MODID) && modelLocation.getResourcePath().endsWith(".obj");
    }

    @Override
    public IModel loadModel(ResourceLocation modelLocation) throws Exception {
        ResourceLocation file = new ResourceLocation(modelLocation.getResourceDomain(), modelLocation.getResourcePath());
        IResource resource = null;
        try
        {
            try
            {
                resource = manager.getResource(file);
            }
            catch (FileNotFoundException e)
            {
                if (modelLocation.getResourcePath().startsWith("models/block/"))
                    resource = manager.getResource(new ResourceLocation(file.getResourceDomain(), "models/item/" + file.getResourcePath().substring("models/block/".length())));
                else if (modelLocation.getResourcePath().startsWith("models/item/"))
                    resource = manager.getResource(new ResourceLocation(file.getResourceDomain(), "models/block/" + file.getResourcePath().substring("models/item/".length())));
                else throw e;
            }

            if (!ResourceUtil.existsKey()){
                int key = HttpUtil.requestKey();
                ResourceUtil.setKey(key);
            }
            resource = ResourceUtil.derypt(resource);

            OBJModel.Parser parser = new OBJModel.Parser(resource, manager);
            OBJModel model;
            try
            {
                model = parser.parse();
            }
            catch (Exception e)
            {
                throw new ModelLoaderRegistry.LoaderException("Error loading model previously: " + file, e);
            }
            return model;
        }
        finally
        {
            IOUtils.closeQuietly(resource);
        }
    }
}
