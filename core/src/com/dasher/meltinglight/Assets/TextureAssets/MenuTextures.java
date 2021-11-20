package com.dasher.meltinglight.Assets.TextureAssets;

import com.badlogic.gdx.graphics.Texture;
import com.dasher.meltinglight.Assets.GameAssetDescriptor;
import com.dasher.meltinglight.MeltingLight;

public class MenuTextures extends ChildTexturePack {
    public MenuTextures(MeltingLight game, TexturePack parent) {
        super(game, parent);
    }

    @Override
    public String childDir() {
        return "Menu";
    }

    public GameAssetDescriptor<Texture> menuBackground = createDescriptor("main-background-0", extensions.png, parent.getDefaultTextureParameter());
}
