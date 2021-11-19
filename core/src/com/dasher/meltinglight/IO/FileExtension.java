package com.dasher.meltinglight.IO;

public class FileExtension {
    private final String extension;

    public FileExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "." + extension;
    }
}
