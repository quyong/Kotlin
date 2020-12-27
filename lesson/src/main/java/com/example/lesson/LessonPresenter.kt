package com.example.lesson

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient
import com.example.core.utils.Utils.Companion.toast
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

/**
 * Created by QUYONG on 12/27/20
 */
class LessonPresenter(var activity: LessonActivity) {
    companion object {
        const val LESSON_PATH = "lessons"
    }

    private var lessons: List<Lesson> = arrayListOf()

    private val type: Type = object : TypeToken<List<Lesson>>() {}.type

    fun fetchData() {
        HttpClient.get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {
            override fun onSuccess(lessons: List<Lesson>) {
                this@LessonPresenter.lessons = lessons
                activity.runOnUiThread { activity.showResult(lessons) }
            }

            override fun onFailure(message: String?) {
                activity.runOnUiThread { toast(message!!) }
            }
        })
    }

    fun showPlayback() {
        val playbackLessons = lessons.filter { it.state == Lesson.State.PLAYBACK }
        activity.showResult(playbackLessons);
    }
}