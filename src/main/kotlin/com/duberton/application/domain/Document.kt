package com.duberton.application.domain

import com.duberton.application.port.PhoneRepositoryPort
import com.duberton.common.exception.BusinessException
import com.duberton.common.validation.throwIf

data class Document(
    val number: String
) {

    fun isDocumentOwnedByAnotherPerson(phoneRepositoryPort: PhoneRepositoryPort, name: String) {
        val isNotUnique = phoneRepositoryPort.findByName(number, name).count() > 0
        throwIf(isNotUnique) {
            BusinessException(
                Person::class.java.simpleName,
                "Document already exists for another person: $number"
            )
        }
    }
}
