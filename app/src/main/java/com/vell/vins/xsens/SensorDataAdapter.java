//  Copyright (c) 2003-2020 Xsens Technologies B.V. or subsidiaries worldwide.
//  All rights reserved.
//
//  Redistribution and use in source and binary forms, with or without modification,
//  are permitted provided that the following conditions are met:
//
//  1.      Redistributions of source code must retain the above copyright notice,
//           this list of conditions, and the following disclaimer.
//
//  2.      Redistributions in binary form must reproduce the above copyright notice,
//           this list of conditions, and the following disclaimer in the documentation
//           and/or other materials provided with the distribution.
//
//  3.      Neither the names of the copyright holders nor the names of their contributors
//           may be used to endorse or promote products derived from this software without
//           specific prior written permission.
//
//  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
//  EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
//  MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
//  THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
//  SPECIAL, EXEMPLARY OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT
//  OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
//  HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY OR
//  TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
//  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.THE LAWS OF THE NETHERLANDS
//  SHALL BE EXCLUSIVELY APPLICABLE AND ANY DISPUTES SHALL BE FINALLY SETTLED UNDER THE RULES
//  OF ARBITRATION OF THE INTERNATIONAL CHAMBER OF COMMERCE IN THE HAGUE BY ONE OR MORE
//  ARBITRATORS APPOINTED IN ACCORDANCE WITH SAID RULES.
//

package com.vell.vins.xsens;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xsens.dot.android.example.R;

import java.util.ArrayList;
import java.util.Map;

/**
 * A view adapter for item view to present data.
 */
public class SensorDataAdapter extends RecyclerView.Adapter<SensorDataAdapter.SensorDataViewHolder> {

    private static final String TAG = SensorDataAdapter.class.getSimpleName();

    private ArrayList<Map.Entry<String, SensorData>> mDataList;

    /**
     * Default constructor.
     *
     * @param dataList A list contains tag and data
     */
    public SensorDataAdapter(ArrayList<Map.Entry<String, SensorData>> dataList) {
        mDataList = dataList;
    }

    public void updateData(Map<String, SensorData> newData) {
        mDataList = new ArrayList<>(newData.entrySet());
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SensorDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vins_sensor, parent, false);
        return new SensorDataViewHolder(itemView);
    }

    @Override
    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    public void onBindViewHolder(@NonNull SensorDataViewHolder holder, int position) {

        Map.Entry<String, SensorData> entry = mDataList.get(position);

        holder.address.setText("address: " + entry.getKey());
        SensorData d = entry.getValue();
        holder.gry.setText("gry: " + d.getGyr());
        holder.freeAcc.setText("acc: " + d.getFreeAcc());
    }

    @Override
    public int getItemCount() {

        return mDataList == null ? 0 : mDataList.size();
    }

    /**
     * A Customized class for ViewHolder of RecyclerView.
     */
    static class SensorDataViewHolder extends RecyclerView.ViewHolder {

        View rootView;
        TextView address;
        TextView gry;
        TextView freeAcc;

        SensorDataViewHolder(View v) {

            super(v);

            rootView = v;
            address = v.findViewById(R.id.vins_sensor_address);
            gry = v.findViewById(R.id.vins_sensor_gry);
            freeAcc = v.findViewById(R.id.vins_sensor_acc);
        }
    }
}
