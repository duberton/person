package com.duberton.adapter.output.mongodb.extension

import com.duberton.adapter.output.mongodb.entity.PersonEntity
import com.duberton.application.domain.Document
import com.duberton.application.domain.Person

fun Person.toEntity() = PersonEntity(
    name = name,
    type = type.name,
    createdAt = createdAt,
    document = PersonEntity.Document(
        number = document.number
    )
)

fun PersonEntity.toDomain() = Person(
    name = name!!,
    type = enumValueOf(type!!),
    createdAt = createdAt!!,
    document = Document(
        number = document?.number!!
    )
)