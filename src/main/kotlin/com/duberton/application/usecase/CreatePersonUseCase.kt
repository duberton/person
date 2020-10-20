package com.duberton.application.usecase

import com.duberton.application.domain.Person
import com.duberton.application.port.CreatePersonPort
import com.duberton.application.port.PhoneRepositoryPort

class CreatePersonUseCase(private val phoneRepositoryPort: PhoneRepositoryPort) : CreatePersonPort {

    override fun create(person: Person): Person {
        return with(person) {
            validate(phoneRepositoryPort)
            save(phoneRepositoryPort)
            person
        }
    }
}