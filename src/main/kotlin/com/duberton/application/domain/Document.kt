package com.duberton.application.domain

import com.duberton.application.port.PersonRepositoryPort
import com.duberton.common.exception.BusinessException
import com.duberton.common.validation.throwIf

data class Document(
    val number: String
) {

    fun isDocumentOwnedByAnotherPerson(personRepositoryPort: PersonRepositoryPort, name: String) {
        val isNotUnique = personRepositoryPort.findByDocumentNumber(number).count() > 0
        throwIf(isNotUnique) {
            BusinessException(
                Person::class.java.simpleName,
                "Document already exists for another person: $number"
            )
        }
    }
}
