package com.duberton.adapter.input.web

import com.duberton.adapter.input.web.api.request.PersonRequest
import com.duberton.adapter.input.web.controller.PersonController
import com.duberton.application.port.CreatePersonPort
import com.duberton.application.port.FindPersonPort
import com.duberton.common.randomPerson
import com.duberton.common.randomPersonRequest
import io.javalin.http.Context
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class PersonApiTest {

    private val context = mockk<Context>(relaxed = true)
    private val createPersonPort = mockk<CreatePersonPort>()
    private val findPersonPort = mockk<FindPersonPort>()
    private val personApi = PersonController(createPersonPort, findPersonPort)


    @Test
    fun `given that a request comes in to create a person, when i process it then it should invoke the proper ports`() {
        val randomPersonRequest = randomPersonRequest()
        val randomPerson = randomPerson()

        every {
            context.bodyValidator(PersonRequest::class.java).check(any()).check(any()).check(any()).get()
        } returns randomPersonRequest
        every { createPersonPort.create(any()) } returns randomPerson

        personApi.create(context)

        verify { createPersonPort.create(any()) }

    }

}