package com.example.core.utils

import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast
import com.example.core.BaseApplication

/**
 * Created by QUYONG on 12/27/20
 */
class Utils {
    companion object {
        private val displayMetrics = Resources.getSystem().displayMetrics

        fun dp2px(dp: Float): Float = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)

        fun toast(string: String) {
            fun toast(string: String, duration: Int) {
                Toast.makeText(BaseApplication.currentApplication(), string, duration).show();
            }
            toast(string, Toast.LENGTH_SHORT);
        }
    }
}