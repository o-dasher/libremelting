package com.dasher.meltinglight.Assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.Array;
import com.dasher.meltinglight.Assets.FontAssets.FontPack;
import com.dasher.meltinglight.Assets.MusicAssets.MusicPack;
import com.dasher.meltinglight.Assets.SoundAssets.SoundPack;
import com.dasher.meltinglight.Assets.TextureAssets.TexturePack;
import com.dasher.meltinglight.MeltingLight;
import com.dasher.meltinglight.GameContainer;

import lombok.Getter;

public class GameAssetManager extends AssetManager implements GameContainer {
    private final Array<AssetPack<?>> assetPacks = new Array<>();
    private final @Getter MeltingLight game;
    private @Getter TexturePack textures;
    private @Getter SoundPack sounds;
    private @Getter MusicPack musics;
    private @Getter FontPack fonts;

    public GameAssetManager(MeltingLight game) {
        this.game = game;
    }

    public void initPacks() {
        createPack(textures = new TexturePack(game));
        createPack(sounds = new SoundPack(game));
        createPack(musics = new MusicPack(game));
        createPack(fonts = new FontPack(game));
    }

    private void createPack(AssetPack<?> assetPack) {
        assetPacks.add(assetPack);
    }

    private void loadAssetPack(AssetPack<?> assetPack) {
        getSysPrinter().printLoading(assetPack.getClass(), assetPack.dir());
        for (AssetDescriptor<?> assetDescriptor: assetPack.getAssetDescriptors()) {
            load(assetDescriptor);
            getSysPrinter().printLoaded(assetDescriptor.type, assetDescriptor.fileName);
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
