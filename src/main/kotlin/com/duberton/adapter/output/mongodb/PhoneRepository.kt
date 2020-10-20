package com.duberton.adapter.output.mongodb

import com.duberton.adapter.output.mongodb.entity.PersonEntity
import com.duberton.adapter.output.mongodb.extension.toDomain
import com.duberton.adapter.output.mongodb.extension.toEntity
import com.duberton.application.domain.Person
import com.duberton.application.port.PhoneRepositoryPort
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters.and
import com.mongodb.client.model.Filters.eq
import org.litote.kmongo.findOneById
import org.litote.kmongo.getCollection

class PhoneRepository(private val mongoDatabase: MongoDatabase) : PhoneRepositoryPort {

    private fun personCollection() = mongoDatabase.getCollection<PersonEntity>("person")

    override fun findById(id: String) = personCollection().findOneById(id)?.toDomain()

    override fun findFromDocument(accountId: String): List<Person> {
        return personCollection()
            .find(eq("account.accountId", accountId))
            .toList()
            .map { it.toDomain() }
    }

    override fun findByName(accountId: String, name: String): List<Person> {
        return personCollection()
            .find(and(eq("account.accountId", accountId), eq("name", name)))
            .toList()
            .map { it.toDomain() }
    }

    override fun save(person: Person) {
        personCollection().insertOne(person.toEntity())
    }
}