package com.example.core.http

/**
 * Created by QUYONG on 12/27/20
 */
interface EntityCallback<T> {
    fun onSuccess(entity: T)

    fun onFailure(message: String?)
}