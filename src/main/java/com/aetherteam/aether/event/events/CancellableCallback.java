package com.aetherteam.aether.event.events;

public interface CancellableCallback {

    boolean isCanceled();

    void setCanceled(boolean value);
}
