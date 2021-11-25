package com.dasher.meltinglight.Constants;

public class WorldConstants {
    public final int MAX_FPS = 60;
    public final int MIN_FPS = 30;
    public final float TIME_STEP = 1f / MAX_FPS;
    public final float MAX_STEPS = 1f + (float) MAX_FPS / (float) MIN_FPS;
    public final float MAX_TIME_PER_FRAME = TIME_STEP * MAX_STEPS;
    public final int VELOCITY_ITERS = 6;
    public final int POSITION_ITERS = 2;
}
