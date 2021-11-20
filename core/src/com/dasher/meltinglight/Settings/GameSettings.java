package com.dasher.meltinglight.Settings;

import com.badlogic.gdx.utils.Array;
import com.dasher.meltinglight.IO.PersistentStored;
import com.dasher.meltinglight.Interfaces.GameWrapper;
import com.dasher.meltinglight.MeltingLight;

import lombok.Data;
import lombok.Getter;

@Data
public class GameSettings implements PersistentStored, GameWrapper {
    private final @Getter MeltingLight game;
    private Array<GenericSetting> settings = new Array<>();
    private AudioSetting audio;

    public GameSettings(MeltingLight game) {
        this.game = game;
        settings.add(audio = new AudioSetting(game));
    }

    @Override
    public void save() {
        for (GenericSetting setting: settings) {
            setting.save();
        }
        getPreferences().flush();
    }

    @Override
    public void load() {
        for (GenericSetting setting: settings) {
            setting.load();
        }
    }
}
