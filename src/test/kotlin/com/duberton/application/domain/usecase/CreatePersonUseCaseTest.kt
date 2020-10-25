package com.duberton.application.domain.usecase

import com.duberton.application.domain.Document
import com.duberton.application.domain.Person
import com.duberton.application.port.PersonRepositoryPort
import com.duberton.application.usecase.CreatePersonUseCase
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import java.time.LocalDateTime

class CreatePersonUseCaseTest {

    private val personRepositoryPort = mockk<PersonRepositoryPort>()
    private val createPersonPort = CreatePersonUseCase(personRepositoryPort)

    @Test
    fun `given that a person comes in to be created, when i try to create it, then it should invoke the proper ports`() {
        val person = Person(
            name = "eduardo",
            type = Person.Type.NATURAL,
            createdAt = LocalDateTime.now().toString(),
            document = Document(
                number = "123456789"
            )
        )
        every { personRepositoryPort.findByDocumentNumber(any()) } returns emptyList()
        every { personRepositoryPort.save(any()) } returns Unit

        createPersonPort.create(person)

        verify { personRepositoryPort.findByDocumentNumber(any()) }
        verify { personRepositoryPort.save(any()) }
    }

}