package com.dasher.meltinglight.Audio;

import com.badlogic.gdx.audio.Sound;
import com.dasher.meltinglight.Settings.AudioSetting;

public class GameSound extends GameAudio<Sound> implements Sound {
    public GameSound(Sound audio, AudioSetting setting) {
        super(audio, setting);
    }

    @Override
    public long play() {
        return audio.play(setting.getSfxVolume().getValue());
    }

    @Override
    public long play(float volume) {
        return audio.play(setting.getSfxVolume().getValue() * volume);
    }

    @Override
    public long play(float volume, float pitch, float pan) {
        return audio.play(setting.getSfxVolume().getValue() * volume, pitch, pan);
    }

    @Override
    public long loop() {
        return audio.loop(setting.getSfxVolume().getValue());
    }

    @Override
    public long loop(float volume) {
        return audio.loop(setting.getSfxVolume().getValue() * volume);
    }

    @Override
    public long loop(float volume, float pitch, float pan) {
        return audio.loop(setting.getSfxVolume().getValue() * volume, pitch, pan);
    }

    @Override
    public void stop() {
        audio.stop();
    }

    @Override
    public void pause() {
        audio.pause();
    }

    @Override
    public void resume() {
        audio.resume();
    }

    @Override
    public void dispose() {
        audio.dispose();
    }

    @Override
    public void stop(long soundId) {
        audio.stop(soundId);
    }

    @Override
    public void pause(long soundId) {
        audio.pause(soundId);
    }

    @Override
    public void resume(long soundId) {
        audio.resume(soundId);
    }

    @Override
    public void setLooping(long soundId, boolean looping) {
        audio.setLooping(soundId, looping);
    }

    @Override
    public void setPitch(long soundId, float pitch) {
        audio.setPitch(soundId, pitch);
    }

    @Override
    public void setVolume(long soundId, float volume) {
        audio.setVolume(soundId, volume);
    }

    @Override
    public void setPan(long soundId, float pan, float volume) {
        audio.setPan(soundId, pan, volume);
    }
}
