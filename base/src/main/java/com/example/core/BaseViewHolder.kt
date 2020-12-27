package com.example.core

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by QUYONG on 12/27/20
 */
open class BaseViewHolder constructor(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {

    @SuppressLint("UseSparseArrays")
    private val viewHashMap = hashMapOf<Int, View>()

    fun <T : View?> getView(@IdRes id: Int): T? {
        var view = viewHashMap[id]
        if (view == null) {
            view = itemView.findViewById(id)
            viewHashMap[id] = view
        }
        return view as? T
    }

    fun setText(@IdRes id: Int, text: String?) {
        (getView<View>(id) as? TextView)?.text = text
    }

}