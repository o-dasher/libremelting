package com.dasher.meltinglight.Settings;

import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.Array;
import com.dasher.meltinglight.IO.PersistentStored;
import com.dasher.meltinglight.MeltingLight;

import lombok.Data;

@Data
public class GameSettings implements PersistentStored {
    private Array<GenericSetting> settings = new Array<>();
    private Preferences preferences;

    private AudioSetting audio;

    public GameSettings(MeltingLight game) {
        this.preferences = game.getPreferences();
        settings.add(audio = new AudioSetting(game));
    }

    @Override
    public void save() {
        for (GenericSetting setting: settings) {
            setting.save();
        }
        preferences.flush();
    }

    @Override
    public void load() {
        for (GenericSetting setting: settings) {
            setting.load();
        }
    }
}
