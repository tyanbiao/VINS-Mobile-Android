package com.vell.vins.xsens;

import java.util.HashSet;
import java.util.Set;
import com.xsens.dot.android.sdk.events.XsensDotData;


public class SensorDataManager {
    private final Set<SensorDataListener> listeners;
    private static SensorDataManager instance = null;
    private SensorDataManager() {
        this.listeners = new HashSet<>();
    }

    public static SensorDataManager getInstance() {
        if (instance == null) {
            instance = new SensorDataManager();
        }
        return instance;
    }

    public void addListener(SensorDataListener listener) {
        listeners.add(listener);
    }

    public void removeListener(SensorDataListener listener) {
        listeners.remove(listener);
    }

    public void updateData(String address, XsensDotData data) {
        for (SensorDataListener listener : listeners) {
            listener.onXsensDataChanged(address, data);
        }
    }
}
