package com.dasher.meltinglight.IO;

public class SysPrinter {
    public void print(String s) {
        System.out.println(s);
    }

    public void printShow(String prefix, Class<?> klass, String suffix) {
        print(createShowString(prefix, klass, suffix));
    }

    public void printNew(Class<?> klass, String suffix) {
        printShow("New", klass, suffix);
    }

    public void printLoaded(Class<?> klass, String suffix) {
        printShow("Loaded", klass, suffix);
    }

    public void printLoading(Class<?> klass, String suffix) {
        printShow("Loading", klass, suffix);
    }

    public String createShowString(String prefix, Class<?> klass, String suffix) {
        return prefix + " " + klass.getSimpleName() + ": " + suffix;
    }
}
