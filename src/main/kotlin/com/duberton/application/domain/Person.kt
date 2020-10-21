package com.duberton.application.domain

import com.duberton.application.port.PersonRepositoryPort

data class Person(
    val name: String,
    val type: Type,
    val document: Document,
    val createdAt: String
) {

    enum class Type {
        NATURAL,
        JURIDICAL
    }

    fun validate(personRepositoryPort: PersonRepositoryPort) {
        document.isDocumentOwnedByAnotherPerson(personRepositoryPort, name)
    }

    fun save(personRepositoryPort: PersonRepositoryPort) {
        personRepositoryPort.save(this)
    }
}