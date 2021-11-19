package com.dasher.meltinglight.Assets;

import com.dasher.meltinglight.MeltingLight;

public abstract class ChildPack<T, P extends AssetPack<T>> extends AssetPack<T> {
    private final P parent;

    public ChildPack(MeltingLight game, P parent) {
        super(game);
        this.parent = parent;
    }

    public abstract String childDir();

    @Override
    public Class<T> assetType() {
        return parent.assetType();
    }

    @Override
    public String dir() {
        return parent.dir() + "/" + childDir();
    }
}
