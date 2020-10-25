package com.duberton.common

import com.duberton.adapter.input.web.api.request.PersonRequest
import com.duberton.application.domain.Document
import com.duberton.application.domain.Person
import org.jeasy.random.EasyRandom
import java.time.LocalDateTime

fun randomPerson() = Person(
    name = EasyRandom().nextObject(String::class.java),
    type = Person.Type.NATURAL,
    createdAt = LocalDateTime.now().toString(),
    document = Document(
        number = EasyRandom().nextInt().toString()
    )
)

fun randomPersonRequest() = PersonRequest(
    name = EasyRandom().nextObject(String::class.java),
    type = "NATURAL",
    document = PersonRequest.Document(
        number = EasyRandom().nextInt().toString()
    )
)