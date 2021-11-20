package com.dasher.meltinglight.Assets;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.utils.Array;
import com.dasher.meltinglight.IO.FileExtension;
import com.dasher.meltinglight.IO.FileExtensions;
import com.dasher.meltinglight.MeltingLight;

import lombok.Getter;

public abstract class AssetPack<T> {
    private final MeltingLight game;
    protected FileExtensions extensions;

    public AssetPack(MeltingLight game) {
        this.game = game;
        this.extensions = game.getFileExtensions();
    }

    public abstract String dir();

    private final @Getter Array<GameAssetDescriptor<T>> assetDescriptors = new Array<>();
    private final @Getter Array<ChildPack<T, AssetPack<T>>> childPacks = new Array<>();

    public abstract Class<T> assetType();

    public GameAssetDescriptor<T> createDescriptor(String fileName, FileExtension extension, AssetLoaderParameters<T> parameters) {
        String realFileName = dir() + "/" + fileName + extension.toString();
        GameAssetDescriptor<T> assetDescriptor = parameters == null ?
                new GameAssetDescriptor<T>(game.getAssets(), realFileName, assetType())
                : new GameAssetDescriptor<T>(game.getAssets(), realFileName, assetType(), parameters);
        assetDescriptors.add(assetDescriptor);
        return assetDescriptor;
    }

    public GameAssetDescriptor<T> createDescriptor(String fileName, FileExtension extension) {
        return createDescriptor(fileName, extension, null);
    }

    public GameAssetDescriptor<T> createDescriptor(String fileName) {
        return createDescriptor(fileName, game.getFileExtensions().none);
    }

    public ChildPack<T, AssetPack<T>> createChild(ChildPack<T, AssetPack<T>> childPack) {
        childPacks.add(childPack);
        return childPack;
    }
}
