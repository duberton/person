package com.duberton.adapter.input.web.config

import com.duberton.adapter.input.web.PersonRoute
import com.duberton.adapter.input.web.api.PersonApi
import com.duberton.adapter.input.web.controller.PersonController
import com.duberton.application.port.CreatePersonPort
import com.duberton.application.usecase.CreatePersonUseCase
import com.duberton.application.usecase.FindPersonUseCase
import org.koin.dsl.module.module

val apiConfig = module {
    single { PersonRoute(get()) }
    single { PersonController(get(), get()) } bind PersonApi::class
    single { CreatePersonUseCase(get()) } bind CreatePersonPort::class
    single { FindPersonUseCase(get()) } bind FindPersonUseCase::class
}

