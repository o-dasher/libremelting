package com.dasher.meltinglight.Tasks;



public abstract class ClockTask implements UpdateAbleTask{
    private boolean isCancelled = false;
    private boolean isRepeating = false;
    private float timeSeconds = 0f;
    private float period;

    public ClockTask(float period) {
        this.period = period;
    }

    @Override
    public void update(float delta) {
        if (!isCancelled) {
            timeSeconds += delta;
            if (timeSeconds > period) {
                run();
                if (isRepeating) {
                    timeSeconds -= period;
                } else {
                    cancel();
                }
            }
        }
    }

    public void reset() {
        timeSeconds = 0;
        isCancelled = false;
    }

    public abstract void run();

    public void setRepeating(boolean repeating) {
        isRepeating = repeating;
    }

    public void cancel() {
        isCancelled = true;
        timeSeconds = 0;
        period = 0;
    }

    public boolean isCancelled() {
        return isCancelled;
    }
}
