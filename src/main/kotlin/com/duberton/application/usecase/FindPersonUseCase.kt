package com.duberton.application.usecase

import com.duberton.application.port.FindPersonPort
import com.duberton.application.port.PhoneRepositoryPort

class FindPersonUseCase(private val phoneRepositoryPort: PhoneRepositoryPort) : FindPersonPort {

    override fun findPersonById(id: String) = phoneRepositoryPort.findById(id)

}