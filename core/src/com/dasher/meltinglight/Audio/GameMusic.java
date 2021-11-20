package com.dasher.meltinglight.Audio;

import com.badlogic.gdx.audio.Music;
import com.dasher.meltinglight.Settings.AudioSetting;

public class GameMusic extends GameAudio<Music> implements Music {

    public GameMusic(Music audio, AudioSetting setting) {
        super(audio, setting);
        setVolume(setting.getSfxVolume().getValue());
    }

    @Override
    public void play() {
        audio.play();
    }

    @Override
    public void pause() {
        audio.pause();
    }

    @Override
    public void stop() {
        audio.stop();
    }

    @Override
    public boolean isPlaying() {
        return audio.isPlaying();
    }

    @Override
    public void setLooping(boolean isLooping) {
        audio.setLooping(isLooping);
    }

    @Override
    public boolean isLooping() {
        return audio.isLooping();
    }

    @Override
    public void setVolume(float volume) {
        audio.setVolume(setting.getSfxVolume().getValue() * volume);
    }

    @Override
    public float getVolume() {
        return audio.getVolume();
    }

    @Override
    public void setPan(float pan, float volume) {
        audio.setPan(pan, setting.getSfxVolume().getValue() * volume);
    }

    @Override
    public void setPosition(float position) {
        audio.setPosition(position);
    }

    @Override
    public float getPosition() {
        return audio.getPosition();
    }

    @Override
    public void dispose() {
        audio.dispose();
    }

    @Override
    public void setOnCompletionListener(OnCompletionListener listener) {
        audio.setOnCompletionListener(listener);
    }
}
