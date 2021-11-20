package com.dasher.meltinglight.Assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.Array;
import com.dasher.meltinglight.Assets.MusicAssets.MusicPack;
import com.dasher.meltinglight.Assets.SoundAssets.SoundPack;
import com.dasher.meltinglight.Assets.TextureAssets.TexturePack;
import com.dasher.meltinglight.MeltingLight;

import lombok.Getter;

public class GameAssetManager extends AssetManager {
    private final Array<AssetPack<?>> assetPacks = new Array<>();
    private final MeltingLight game;
    private @Getter TexturePack textures;
    private @Getter SoundPack sounds;
    private @Getter MusicPack musics;

    public GameAssetManager(MeltingLight game) {
        this.game = game;
    }

    public void initPacks() {
        createPack(textures = new TexturePack(game));
        createPack(sounds = new SoundPack(game));
        createPack(musics = new MusicPack(game));
    }

    private void createPack(AssetPack<?> assetPack) {
        assetPacks.add(assetPack);
    }

    private void loadAssetPack(AssetPack<?> assetPack) {
        game.getSysPrinter().printLoading(assetPack.getClass(), assetPack.dir());
        for (AssetDescriptor<?> assetDescriptor: assetPack.getAssetDescriptors()) {
            load(assetDescriptor);
            game.getSysPrinter().printLoaded(assetDescriptor.type, assetDescriptor.fileName);
        }
        for (ChildPack<?, ?> childPack: assetPack.getChildPacks()) {
            loadAssetPack(childPack);
        }
    }

    public void load() {
        for (AssetPack<?> assetPack: assetPacks) {
            loadAssetPack(assetPack);
        }
    }
}
