package com.dasher.meltinglight.Settings.PreferenceType;

import com.dasher.meltinglight.Settings.GenericSetting;

public class FloatPreference extends GenericPreference<Float> {

    public FloatPreference(GenericSetting parent, String key, Float value) {
        super(parent, key, value);
    }

    @Override
    public void save() {
        parent.getPreferences().putFloat(getNormalizedPreference().key, value);
    }

    @Override
    public void load() {
        if (canLoad()) loadValue(parent.getPreferences().getFloat(getNormalizedPreference().key));
    }
}
