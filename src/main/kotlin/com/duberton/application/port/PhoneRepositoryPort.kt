package com.duberton.application.port

import com.duberton.application.domain.Person

interface PhoneRepositoryPort {

    fun findById(id: String): Person?

    fun findFromDocument(accountId: String): List<Person>

    fun findByName(accountId: String, name: String): List<Person>

    fun save(person: Person)

}