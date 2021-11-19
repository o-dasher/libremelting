package com.dasher.meltinglight.Assets.TextureAssets;

import com.badlogic.gdx.graphics.Texture;
import com.dasher.meltinglight.Assets.GameAssetDescriptor;
import com.dasher.meltinglight.MeltingLight;

public class IntroTextures extends ChildTexturePack {
    public IntroTextures(MeltingLight game, TexturePack parent) {
        super(game, parent);
    }

    @Override
    public String childDir() {
        return "Intro";
    }

    public GameAssetDescriptor<Texture> logo = createDescriptor("logo", extensions.png, parent.defaultTextureParameter);
}
