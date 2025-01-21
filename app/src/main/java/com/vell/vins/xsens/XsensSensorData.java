package com.vell.vins.xsens;

import com.xsens.dot.android.sdk.events.XsensDotData;

public class XsensSensorData implements SensorData {
    private final XsensDotData xsensDotData;
    private final String address;

    public XsensSensorData(String address, XsensDotData xsensDotData) {
        this.xsensDotData = xsensDotData;
        this.address = address;
    }

    @Override
    public String getFreeAcc() {

        float[] value = xsensDotData.getFreeAcc();

        String valueStr =
                String.format("%.3f", value[0]) + ", " +
                        String.format("%.3f", value[1]) + ", " +
                        String.format("%.3f", value[2]);

        return valueStr;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getGyr() {
        double[] value = xsensDotData.getGyr();

        String valueStr =
                String.format("%.3f", value[0]) + ", " +
                        String.format("%.3f", value[1]) + ", " +
                        String.format("%.3f", value[2]);

        return valueStr;
    }

    @Override
    public String getEuler() {

        double[] value = xsensDotData.getEuler();

        String valueStr =
                String.format("%.3f", value[0]) + ", " +
                        String.format("%.3f", value[1]) + ", " +
                        String.format("%.3f", value[2]);

        return valueStr;
    }
}
