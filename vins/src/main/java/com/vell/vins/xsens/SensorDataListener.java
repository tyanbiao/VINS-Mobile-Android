package com.vell.vins.xsens;
import com.xsens.dot.android.sdk.events.XsensDotData;

public interface SensorDataListener {
    void onXsensDataChanged(String address, XsensDotData data);
}
