package com.dasher.meltinglight.Assets.MusicAssets;


import com.badlogic.gdx.audio.Music;
import com.dasher.meltinglight.Assets.GameAssetDescriptor;
import com.dasher.meltinglight.MeltingLight;

public class MenuMusics extends ChildMusicPack {
    public MenuMusics(MeltingLight game, MusicPack parent) {
        super(game, parent);
    }

    @Override
    public String childDir() {
        return "Menu";
    }

    public final GameAssetDescriptor<Music> menuAmbient = createDescriptor("menu-ambient", getFileExtensions().wav);
}
