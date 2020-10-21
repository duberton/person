package com.duberton.application.usecase

import com.duberton.application.domain.Person
import com.duberton.application.port.CreatePersonPort
import com.duberton.application.port.PersonRepositoryPort

class CreatePersonUseCase(private val personRepositoryPort: PersonRepositoryPort) : CreatePersonPort {

    override fun create(person: Person): Person {
        return with(person) {
            validate(personRepositoryPort)
            save(personRepositoryPort)
            person
        }
    }
}