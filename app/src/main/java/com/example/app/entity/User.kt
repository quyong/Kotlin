package com.example.app.entity

import com.example.core.utils.Utils

/**
 * Created by QUYONG on 12/26/20
 */
data class User(var username: String = "", var password: String = "", var code: String="")

fun User.verify(): Boolean = when {
    username.length < 4 -> {
        Utils.toast("用户名太短")
        false
    }
    password.length < 4 -> {
        Utils.toast("密码太短")
        false
    }
    code.length < 4 -> {
        Utils.toast("验证码太短")
        false
    }
    else -> true
}