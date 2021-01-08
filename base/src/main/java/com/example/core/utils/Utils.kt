package com.example.core.utils

import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast
import com.example.core.BaseApplication

/**
 * Created by QUYONG on 12/27/20
 */

private val displayMetrics = Resources.getSystem().displayMetrics
fun Float.dp2px(): Float = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, displayMetrics)

object Utils {
    fun toast(string: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(BaseApplication.currentApplication, string, duration).show();
    }
}

