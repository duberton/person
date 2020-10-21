package com.duberton.application.port

import com.duberton.application.domain.Person

interface PersonRepositoryPort {

    fun findById(id: String): Person?

    fun findByDocumentNumber(documentNumber: String): List<Person>

    fun save(person: Person)

}