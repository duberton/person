package com.duberton.adapter.output.mongodb.config

import com.duberton.adapter.output.mongodb.PersonRepository
import com.duberton.application.port.PersonRepositoryPort
import com.mongodb.ConnectionString
import com.mongodb.client.MongoDatabase
import org.koin.dsl.module.module
import org.litote.kmongo.KMongo

val mongoConfig = module {
    single { PersonRepository(get()) } bind PersonRepositoryPort::class
    single { mongoDatabase(getProperty("mongodb.connection.string")) }
}

fun mongoDatabase(connectionString: String): MongoDatabase =
    KMongo.createClient(ConnectionString(connectionString)).getDatabase("person")