package com.example.app.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView
import com.example.app.R
import com.example.core.utils.Utils
import java.util.*

/**
 * Created by QUYONG on 12/26/20
 */
class CodeView constructor(context: Context, attrs: AttributeSet?) : AppCompatTextView(context, attrs) {
    private val paint = Paint()
    private val codeArray = arrayOf("kotlin",
            "android",
            "java",
            "http",
            "https",
            "okhttp",
            "retrofit",
            "tcp/ip")

    constructor(context: Context) : this(context, null) {
    }

    init {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        gravity = Gravity.CENTER
        setBackgroundColor(getContext().getColor(R.color.colorPrimary))
        setTextColor(Color.WHITE)

        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.color = getContext().getColor(R.color.colorAccent)
        paint.strokeWidth = Utils.dp2px(6f)

        updateCode();
    }

    fun updateCode() {
        val random = Random().nextInt(codeArray.size);
        text = codeArray[random]
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawLine(0f, height.toFloat(), width.toFloat(), 0f, paint)
        super.onDraw(canvas)
    }
}