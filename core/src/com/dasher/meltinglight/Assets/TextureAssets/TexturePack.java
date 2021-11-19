package com.dasher.meltinglight.Assets.TextureAssets;

import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.graphics.Texture;
import com.dasher.meltinglight.Assets.AssetPack;
import com.dasher.meltinglight.Assets.ChildPack;
import com.dasher.meltinglight.MeltingLight;

public class TexturePack extends AssetPack<Texture> {
    public TextureLoader.TextureParameter defaultTextureParameter;
    public IntroTextures intro;

    public TexturePack(MeltingLight game) {
        super(game);
        defaultTextureParameter = new TextureLoader.TextureParameter();
        defaultTextureParameter.genMipMaps = true;
        defaultTextureParameter.minFilter = Texture.TextureFilter.MipMapLinearLinear;
        defaultTextureParameter.magFilter = Texture.TextureFilter.MipMapLinearLinear;
        createChild(intro = new IntroTextures(game,this));
    }

    @Override
    public String dir() {
        return "Textures";
    }

    @Override
    public Class<Texture> assetType() {
        return Texture.class;
    }
}
