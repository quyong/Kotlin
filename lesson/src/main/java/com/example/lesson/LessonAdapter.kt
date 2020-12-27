package com.example.lesson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.core.BaseViewHolder
import com.example.lesson.entity.Lesson


/**
 * Created by QUYONG on 12/27/20
 */
class LessonAdapter : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {

    private var list: List<Lesson> = listOf()

    fun updateAndNotify(list: List<Lesson>) {
        this.list = list;
        notifyDataSetChanged();
    }

    override fun getItemCount(): Int = list.size

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): LessonViewHolder = LessonViewHolder.onCreate(parent)

    override fun onBindViewHolder(@NonNull holder: LessonViewHolder, position: Int) {
        holder.onBind(list[position]);
    }

    /**
     * 静态内部类
     */
    class LessonViewHolder constructor(@NonNull itemView: View) : BaseViewHolder(itemView) {
        companion object {
            @NonNull
            fun onCreate(parent: ViewGroup): LessonViewHolder {
                return LessonViewHolder(LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.item_lesson, parent, false));
            }
        }

        fun onBind(lesson: Lesson) {
            val date: String? = lesson.date ?: "日期待定"
            setText(R.id.tv_date, date);
            setText(R.id.tv_content, lesson.content)

            val state: Lesson.State = lesson.state;

            state?.let {
                setText(R.id.tv_state, state.stateName());
                val colorRes = when (state) {
                    Lesson.State.PLAYBACK -> {
                        R.color.playback
                    }
                    Lesson.State.LIVE ->
                        R.color.live
                    Lesson.State.WAIT ->
                        R.color.wait
                }
                val backgroundColor: Int = itemView.context.getColor(colorRes);
                (getView<TextView>(R.id.tv_state) as? TextView)?.setBackgroundColor(backgroundColor);
            }

        }
    }
}