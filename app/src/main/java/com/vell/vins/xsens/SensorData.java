package com.vell.vins.xsens;

import com.xsens.dot.android.sdk.events.XsensDotData;

public interface SensorData {
    public String getFreeAcc();
    public String getAddress();
    public String getGyr();
    public String getEuler();
}
