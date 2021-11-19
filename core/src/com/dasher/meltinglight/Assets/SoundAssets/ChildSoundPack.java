package com.dasher.meltinglight.Assets.SoundAssets;

import com.badlogic.gdx.audio.Sound;
import com.dasher.meltinglight.Assets.AssetPack;
import com.dasher.meltinglight.Assets.ChildPack;
import com.dasher.meltinglight.MeltingLight;

public abstract class ChildSoundPack extends ChildPack<Sound, AssetPack<Sound>> {
    protected SoundPack parent;

    public ChildSoundPack(MeltingLight game, SoundPack parent) {
        super(game, parent);
        this.parent = parent;
    }
}
