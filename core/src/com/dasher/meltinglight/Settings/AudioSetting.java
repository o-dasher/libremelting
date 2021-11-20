package com.dasher.meltinglight.Settings;

import com.badlogic.gdx.Preferences;
import com.dasher.meltinglight.Settings.PreferenceType.FloatPreference;

import lombok.Getter;
import lombok.Setter;

public class AudioSetting extends GenericSetting {
    private @Getter @Setter FloatPreference sfxVolume = new FloatPreference(this,"sfx", 1.0f);
    private @Getter @Setter FloatPreference musicVolume = new FloatPreference(this,"msc", 1.0f);

    public AudioSetting(Preferences preferences) {
        super(preferences);
        genericPreferences.add(sfxVolume);
        genericPreferences.add(musicVolume);
    }

    @Override
    public String name() {
        return "Audio";
    }
}
