package com.dasher.meltinglight.Assets.TextureAssets;

import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.graphics.Texture;
import com.dasher.meltinglight.Assets.AssetPack;
import com.dasher.meltinglight.MeltingLight;

import lombok.Getter;

public class TexturePack extends AssetPack<Texture> {
    private final @Getter TextureLoader.TextureParameter defaultTextureParameter;
    private final @Getter IntroTextures intro;
    private final @Getter MenuTextures menu;

    public TexturePack(MeltingLight game) {
        super(game);
        defaultTextureParameter = new TextureLoader.TextureParameter();
        defaultTextureParameter.genMipMaps = true;
        defaultTextureParameter.minFilter = Texture.TextureFilter.MipMapLinearLinear;
        defaultTextureParameter.magFilter = Texture.TextureFilter.MipMapLinearLinear;
        createChild(intro = new IntroTextures(game,this));
        createChild(menu = new MenuTextures(game, this));
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
