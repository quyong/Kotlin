package com.example.lesson.entity

/**
 * Created by QUYONG on 12/27/20
 */
data class Lesson(var date: String?, var content: String?, var state: State) {

    enum class State {
        PLAYBACK {
            override fun stateName(): String = "有回放"
        },

        LIVE {
            override fun stateName(): String = "正在直播"
        },

        WAIT {
            override fun stateName(): String = "等待中"
        };

        abstract fun stateName(): String
    }
}