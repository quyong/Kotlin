package com.example.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.app.entity.User
import com.example.app.entity.verify
import com.example.app.widget.CodeView
import com.example.core.utils.CacheUtils
import com.example.lesson.LessonActivity

/**
 * Created by QUYONG on 12/25/20
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val usernameKey = "username"
    private val passwordKey = "password"

    private lateinit var et_username: EditText
    private lateinit var et_password: EditText
    private lateinit var et_code: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        et_code = findViewById(R.id.et_code)

        et_username.setText(CacheUtils.get(usernameKey))
        et_password.setText(CacheUtils.get(passwordKey))
        et_code = findViewById(R.id.et_code)

        val btn_login = findViewById<Button>(R.id.btn_login)
        val img_code = findViewById<CodeView>(R.id.code_view)

        btn_login.setOnClickListener(this)
        img_code.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v) {
            is CodeView -> v.updateCode()
            is Button -> this.login()
        }
    }

    private fun login() {
        val username = et_username.text.toString()
        val password = et_password.text.toString()
        val code = et_code.text.toString()

        val user = User(username, password, code)

        if (user.verify()) {
            CacheUtils.save(usernameKey, username)
            CacheUtils.save(passwordKey, password)
            this.startActivity(Intent(this, LessonActivity::class.java))
        }
    }

}