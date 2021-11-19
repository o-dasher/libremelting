package com.dasher.meltinglight.Assets.SoundAssets;

import com.badlogic.gdx.audio.Sound;
import com.dasher.meltinglight.Assets.GameAssetDescriptor;
import com.dasher.meltinglight.MeltingLight;

public class IntroSounds extends ChildSoundPack {
    public IntroSounds(MeltingLight game, SoundPack parent) {
        super(game, parent);
    }

    @Override
    public String childDir() {
        return "Intro";
    }

    public GameAssetDescriptor<Sound> whoosh = createDescriptor("whoosh", extensions.mp3);
}
