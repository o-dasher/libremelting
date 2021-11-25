package com.dasher.meltinglight.Assets;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.utils.Array;
import com.dasher.meltinglight.IO.FileExtension;
import com.dasher.meltinglight.MeltingLight;
import com.dasher.meltinglight.GameContainer;

import lombok.Getter;

public abstract class AssetPack<T> implements GameContainer {
    private final @Getter MeltingLight game;

    public AssetPack(MeltingLight game) {
        this.game = game;
    }

    public abstract String dir();

    private final @Getter Array<GameAssetDescriptor<T>> assetDescriptors = new Array<>();
    private final @Getter Array<ChildPack<T, AssetPack<T>>> childPacks = new Array<>();

    public abstract Class<T> assetType();

    public GameAssetDescriptor<T> createDescriptor(String fileName, FileExtension extension, AssetLoaderParameters<T> parameters) {
        String realFileName = dir() + "/" + fileName + extension.toString();
        GameAssetDescriptor<T> assetDescriptor = parameters == null ?
                new GameAssetDescriptor<T>(getAssets(), realFileName, assetType())
                : new GameAssetDescriptor<T>(getAssets(), realFileName, assetType(), parameters);
        assetDescriptors.add(assetDescriptor);
        return assetDescriptor;
    }

    public GameAssetDescriptor<T> createDescriptor(String fileName, FileExtension extension) {
        return createDescriptor(fileName, extension, null);
    }

    public GameAssetDescriptor<T> createDescriptor(String fileName) {
        return createDescriptor(fileName, getFileExtensions().none);
    }

    public ChildPack<T, AssetPack<T>> createChild(ChildPack<T, AssetPack<T>> childPack) {
        childPacks.add(childPack);
        return childPack;
    }
}
