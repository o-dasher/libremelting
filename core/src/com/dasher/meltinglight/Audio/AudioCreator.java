package com.dasher.meltinglight.Audio;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.dasher.meltinglight.Settings.AudioSetting;

public class AudioCreator {
    private final AudioSetting audioSetting;

    public AudioCreator(AudioSetting audioSetting) {
        this.audioSetting = audioSetting;
    }

    public GameSound newSound(Sound sound) {
        return new GameSound(sound, audioSetting);
    }

    public GameMusic newMusic(Music music) {
        return new GameMusic(music, audioSetting);
    }
}
