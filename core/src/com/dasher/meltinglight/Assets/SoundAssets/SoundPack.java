package com.dasher.meltinglight.Assets.SoundAssets;

import com.badlogic.gdx.audio.Sound;
import com.dasher.meltinglight.Assets.AssetPack;
import com.dasher.meltinglight.MeltingLight;

import lombok.Getter;

public class SoundPack extends AssetPack<Sound> {
    private final @Getter IntroSounds intro;

    public SoundPack(MeltingLight game) {
        super(game);
        createChild(intro = new IntroSounds(game, this));
    }

    @Override
    public String dir() {
        return "Sounds";
    }

    @Override
    public Class<Sound> assetType() {
        return Sound.class;
    }
}
