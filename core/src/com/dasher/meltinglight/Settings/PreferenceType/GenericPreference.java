package com.dasher.meltinglight.Settings.PreferenceType;


import com.dasher.meltinglight.IO.PersistentStored;
import com.dasher.meltinglight.Settings.GenericSetting;


import lombok.Getter;

public abstract class GenericPreference<T> implements PersistentStored {
    protected final GenericSetting parent;
    protected final @Getter String key;
    protected @Getter T value;
    private GenericPreference<T> normalizedPreference;

    public GenericPreference(GenericSetting parent, String key, T value) {
        this.parent = parent;
        this.key = key;
        this.value = value;
    }

    protected GenericPreference<T> getNormalizedPreference() {
        return normalizedPreference == null ? normalizedPreference = new GenericPreference<T>(
                parent, parent.getKeyForPreference(this), value
        ) {
            @Override
            public void save() {

            }

            @Override
            public void load() {

            }
        } : normalizedPreference;
    }

    public void loadValue(T value) {
        setValue(value);
        parent.getPrinter().printLoaded(getClass(), getNormalizedPreference().getKey()+" "+value);
    }

    public void setValue(T value) {
        getNormalizedPreference().value = value;
        this.value = value;
    }

    public boolean canLoad() {
        return parent.getPreferences().contains(getNormalizedPreference().getKey());
    }
}
