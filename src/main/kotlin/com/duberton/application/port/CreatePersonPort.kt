package com.duberton.application.port

import com.duberton.application.domain.Person

interface CreatePersonPort {

    fun create(person: Person): Person

}