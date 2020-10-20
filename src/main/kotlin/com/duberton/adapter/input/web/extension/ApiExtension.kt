package com.duberton.adapter.input.web.extension

import com.duberton.adapter.input.web.api.request.PersonRequest
import com.duberton.adapter.input.web.api.response.PersonResponse
import com.duberton.application.domain.Document
import com.duberton.application.domain.Person
import java.time.LocalDateTime

fun PersonRequest.toDomain() = Person(
    name = name,
    type = enumValueOf(type),
    createdAt = LocalDateTime.now().toString(),
    document = Document(
        number = document.number
    )
)

fun Person.toResponse() = PersonResponse(
    name = name,
    type = type.name,
    createdAt = createdAt,
    document = PersonResponse.Document(
        number = document.number
    )
)