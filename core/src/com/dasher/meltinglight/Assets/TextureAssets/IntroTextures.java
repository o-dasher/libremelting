package com.dasher.meltinglight.Assets.TextureAssets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;
import com.dasher.meltinglight.Assets.AssetPack;
import com.dasher.meltinglight.Assets.ChildPack;
import com.dasher.meltinglight.MeltingLight;

public class IntroTextures extends ChildTexturePack {
    public IntroTextures(MeltingLight game, TexturePack parent) {
        super(game, parent);
    }

    @Override
    public String childDir() {
        return "Intro";
    }

    public AssetDescriptor<Texture> sprite = createDescriptor(
            "sprite", extensions.jpg, parent.defaultTextureParameter
    );
}
