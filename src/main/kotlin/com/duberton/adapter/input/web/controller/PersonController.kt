package com.duberton.adapter.input.web.controller

import com.duberton.adapter.input.web.api.PersonApi
import com.duberton.adapter.input.web.api.request.PersonRequest
import com.duberton.adapter.input.web.extension.toDomain
import com.duberton.adapter.input.web.extension.toResponse
import com.duberton.application.port.CreatePersonPort
import com.duberton.application.port.FindPersonPort
import io.javalin.http.Context
import io.javalin.http.NotFoundResponse

class PersonController(
    private val createPersonPort: CreatePersonPort,
    private val findPersonPort: FindPersonPort
) : PersonApi {

    override fun create(ctx: Context) {
        val personRequest = ctx.bodyValidator(PersonRequest::class.java)
            .check({ it.name.isNotBlank() })
            .check({ it.type.isNotBlank() })
            .check({ it.document.number.isNotBlank() }).get()
        val person = createPersonPort.create(personRequest.toDomain())
        ctx.json(person.toResponse())
    }

    override fun findById(ctx: Context) {
        val id = ctx.pathParam("id")
        val person = findPersonPort.findPersonById(id) ?: throw NotFoundResponse(id)
        ctx.json(person.toResponse())
    }
}