package com.duberton.adapter.input.web

import com.duberton.adapter.input.web.api.PersonApi
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*

class PhoneRoute(private val personApi: PersonApi) {

    fun handlers(app: Javalin) {
        app.routes {
            path("/v1/person") {
                post(personApi::create)
                get("/:id", personApi::findById)
            }
        }
    }
}