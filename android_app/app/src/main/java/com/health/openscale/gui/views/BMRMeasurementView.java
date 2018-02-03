/* Copyright (C) 2014  olie.xdev <olie.xdev@googlemail.com>
*
*    This program is free software: you can redistribute it and/or modify
*    it under the terms of the GNU General Public License as published by
*    the Free Software Foundation, either version 3 of the License, or
*    (at your option) any later version.
*
*    This program is distributed in the hope that it will be useful,
*    but WITHOUT ANY WARRANTY; without even the implied warranty of
*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*    GNU General Public License for more details.
*
*    You should have received a copy of the GNU General Public License
*    along with this program.  If not, see <http://www.gnu.org/licenses/>
*/
package com.health.openscale.gui.views;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;

import com.health.openscale.R;
import com.health.openscale.core.datatypes.ScaleMeasurement;
import com.health.openscale.core.evaluation.EvaluationResult;
import com.health.openscale.core.evaluation.EvaluationSheet;

import java.util.Locale;

public class BMRMeasurementView extends FloatMeasurementView {

    public BMRMeasurementView(Context context) {
        super(context, context.getResources().getString(R.string.label_bmr), ContextCompat.getDrawable(context, R.drawable.ic_bmr));
    }

    @Override
    public void updatePreferences(SharedPreferences preferences) {
        setVisible(preferences.getBoolean("weightEnable", true));
    }

    @Override
    public boolean isEditable() {
        return false;
    }

    @Override
    protected String formatValue(float value) {
        return String.format(Locale.getDefault(), "%d", Math.round(value));
    }

    @Override
    protected float getMeasurementValue(ScaleMeasurement measurement) {
        return measurement.getBMR(getScaleUser());
    }

    @Override
    protected void setMeasurementValue(float value, ScaleMeasurement measurement) {
        // Empty
    }

    @Override
    protected String getUnit() {
        return "kCal";
    }

    @Override
    protected float getMaxValue() {
        return 5000;
    }

    @Override
    protected EvaluationResult evaluateSheet(EvaluationSheet evalSheet, float value) {
        return null;
    }
}
