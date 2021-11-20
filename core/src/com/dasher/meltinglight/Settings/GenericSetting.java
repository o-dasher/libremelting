package com.dasher.meltinglight.Settings;


import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.Array;
import com.dasher.meltinglight.IO.PersistentStored;
import com.dasher.meltinglight.IO.SysPrinter;
import com.dasher.meltinglight.MeltingLight;
import com.dasher.meltinglight.Settings.PreferenceType.GenericPreference;

import java.util.Locale;

import lombok.Getter;

public abstract class GenericSetting implements PersistentStored {
    protected final @Getter Array<GenericPreference<?>> genericPreferences = new Array<>();
    private final @Getter Preferences preferences;
    private final @Getter SysPrinter printer;

    public GenericSetting(MeltingLight game) {
        this.printer = game.sysPrinter;
        this.preferences = game.preferences;
    }

    public abstract String name();

    public String getKeyForPreference(GenericPreference<?> genericPreference) {
        return name().toLowerCase(Locale.ROOT)+"_"+genericPreference.getKey().toLowerCase(Locale.ROOT);
    }

    @Override
    public void save() {
        for (GenericPreference<?> genericPreference: genericPreferences) {
            genericPreference.save();
        }
    }

    @Override
    public void load() {
        for (GenericPreference<?> genericPreference: genericPreferences) {
            genericPreference.load();
        }
    }
}
