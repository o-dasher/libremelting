package com.dasher.meltinglight.Assets.MusicAssets;

import com.badlogic.gdx.audio.Music;
import com.dasher.meltinglight.Assets.AssetPack;
import com.dasher.meltinglight.Assets.ChildPack;
import com.dasher.meltinglight.MeltingLight;

public abstract class ChildMusicPack extends ChildPack<Music, AssetPack<Music>> {
    public ChildMusicPack(MeltingLight game, AssetPack<Music> parent) {
        super(game, parent);
    }
}
