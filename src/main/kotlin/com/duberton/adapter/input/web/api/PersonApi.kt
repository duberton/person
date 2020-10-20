package com.duberton.adapter.input.web.api

import io.javalin.http.Context

interface PersonApi {

    fun create(ctx: Context)

    fun findById(ctx: Context)
}