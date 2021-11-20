package com.dasher.meltinglight.Audio;

import com.dasher.meltinglight.Settings.AudioSetting;

public abstract class GameAudio<T> {
    protected T audio;
    protected AudioSetting setting;

    public GameAudio(T audio, AudioSetting setting) {
        this.audio = audio;
        this.setting = setting;
    }
}
