package com.dasher.meltinglight.Assets.TextureAssets;

import com.badlogic.gdx.graphics.Texture;
import com.dasher.meltinglight.Assets.AssetPack;
import com.dasher.meltinglight.Assets.ChildPack;
import com.dasher.meltinglight.MeltingLight;

public abstract class ChildTexturePack extends ChildPack<Texture, AssetPack<Texture>> {
    protected TexturePack parent;

    public ChildTexturePack(MeltingLight game, TexturePack parent) {
        super(game, parent);
        this.parent = parent;
    }
}
