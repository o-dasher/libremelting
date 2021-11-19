package com.dasher.meltinglight.Assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.dasher.meltinglight.Assets.TextureAssets.TexturePack;
import com.dasher.meltinglight.IO.SysPrinter;
import com.dasher.meltinglight.MeltingLight;

public class GameAssetManager extends AssetManager {
    private final Array<AssetPack<?>> assetPacks = new Array<>();
    private final MeltingLight game;
    public TexturePack textures;

    public GameAssetManager(MeltingLight game) {
        this.game = game;
    }

    public void initPacks() {
        createPack(textures = new TexturePack(game));
    }

    private void createPack(AssetPack<?> assetPack) {
        assetPacks.add(assetPack);
    }

    private void loadAssetPack(AssetPack<?> assetPack) {
        game.sysPrinter.printLoading(assetPack.getClass(), assetPack.dir());
        for (AssetDescriptor<?> assetDescriptor: assetPack.assetDescriptors) {
            load(assetDescriptor);
            game.sysPrinter.printLoaded(assetDescriptor.type, assetDescriptor.fileName);
        }
        for (ChildPack<?, ?> childPack: assetPack.childPacks) {
            loadAssetPack(childPack);
        }
    }

    public void load() {
        for (AssetPack<?> assetPack: assetPacks) {
            loadAssetPack(assetPack);
        }
    }
}
