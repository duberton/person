package com.duberton.application.domain

import com.duberton.application.port.PhoneRepositoryPort

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

    fun validate(phoneRepositoryPort: PhoneRepositoryPort) {
        document.isDocumentOwnedByAnotherPerson(phoneRepositoryPort, name)
    }

    fun save(phoneRepositoryPort: PhoneRepositoryPort) {
        phoneRepositoryPort.save(this)
    }
}