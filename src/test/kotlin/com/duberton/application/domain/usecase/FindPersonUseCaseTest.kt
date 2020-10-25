package com.duberton.application.domain.usecase

import com.duberton.application.domain.Document
import com.duberton.application.domain.Person
import com.duberton.application.port.PersonRepositoryPort
import com.duberton.application.usecase.FindPersonUseCase
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import java.time.LocalDateTime

class FindPersonUseCaseTest {

    private val personRepositoryPort = mockk<PersonRepositoryPort>()
    private val findPersonUseCase = FindPersonUseCase(personRepositoryPort)

    @Test
    fun `given that a person is was created, when i try to find it, then it should invoke the proper ports`() {
        val person = Person(
            name = "eduardo",
            type = Person.Type.NATURAL,
            createdAt = LocalDateTime.now().toString(),
            document = Document(
                number = "123456789"
            )
        )
        every { personRepositoryPort.findById(any()) } returns person

        findPersonUseCase.findPersonById("id")

        verify { personRepositoryPort.findById(any()) }
    }

}