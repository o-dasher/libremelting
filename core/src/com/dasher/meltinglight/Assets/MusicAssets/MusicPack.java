package com.dasher.meltinglight.Assets.MusicAssets;

import com.badlogic.gdx.audio.Music;
import com.dasher.meltinglight.Assets.AssetPack;
import com.dasher.meltinglight.MeltingLight;

import lombok.Getter;

public class MusicPack extends AssetPack<Music> {
    private final @Getter MenuMusics menu;

    public MusicPack(MeltingLight game) {
        super(game);
        createChild(menu = new MenuMusics(game, this));
    }

    @Override
    public String dir() {
        return "Musics";
    }

    @Override
    public Class<Music> assetType() {
        return Music.class;
    }
}
