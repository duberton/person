package com.duberton.application.usecase

import com.duberton.application.port.FindPersonPort
import com.duberton.application.port.PersonRepositoryPort

class FindPersonUseCase(private val personRepositoryPort: PersonRepositoryPort) : FindPersonPort {

    override fun findPersonById(id: String) = personRepositoryPort.findById(id)

}