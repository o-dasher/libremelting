package com.dasher.meltinglight.Assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.utils.Array;
import com.dasher.meltinglight.IO.FileExtension;
import com.dasher.meltinglight.IO.FileExtensions;
import com.dasher.meltinglight.MeltingLight;

public abstract class AssetPack<T> {
    private final MeltingLight game;
    protected FileExtensions extensions;

    public AssetPack(MeltingLight game) {
        this.game = game;
        this.extensions = game.fileExtensions;
    }

    public abstract String dir();

    public Array<AssetDescriptor<T>> assetDescriptors = new Array<>();
    public Array<ChildPack<T, AssetPack<T>>> childPacks = new Array<>();

    public abstract Class<T> assetType();

    public AssetDescriptor<T> createDescriptor(String fileName, FileExtension extension, AssetLoaderParameters<T> parameters) {
        String realFileName = dir() + "/" + fileName + extension.toString();
        AssetDescriptor<T> assetDescriptor = parameters == null ?
                new AssetDescriptor<T>(realFileName, assetType())
                : new AssetDescriptor<T>(realFileName, assetType(), parameters);
        assetDescriptors.add(assetDescriptor);
        return assetDescriptor;
    }

    public AssetDescriptor<T> createDescriptor(String fileName, FileExtension extension) {
        return createDescriptor(fileName, extension, null);
    }

    public AssetDescriptor<T> createDescriptor(String fileName) {
        return createDescriptor(fileName, game.fileExtensions.none);
    }

    public ChildPack<T, AssetPack<T>> createChild(ChildPack<T, AssetPack<T>> childPack) {
        childPacks.add(childPack);
        return childPack;
    }
}
