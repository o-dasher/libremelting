package com.dasher.meltinglight.Assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.files.FileHandle;

public class GameAssetDescriptor<T> extends AssetDescriptor<T> {
    private final GameAssetManager assetManager;

    public GameAssetDescriptor(GameAssetManager assetManager, String fileName, Class<T> assetType) {
        super(fileName, assetType);
        this.assetManager = assetManager;
    }

    public GameAssetDescriptor(GameAssetManager assetManager, FileHandle file, Class<T> assetType) {
        super(file, assetType);
        this.assetManager = assetManager;
    }

    public GameAssetDescriptor(GameAssetManager assetManager, String fileName, Class<T> assetType, AssetLoaderParameters<T> params) {
        super(fileName, assetType, params);
        this.assetManager = assetManager;
    }

    public GameAssetDescriptor(GameAssetManager assetManager, FileHandle file, Class<T> assetType, AssetLoaderParameters<T> params) {
        super(file, assetType, params);
        this.assetManager = assetManager;
    }

    public T get() {
        return assetManager.get(this);
    }
}