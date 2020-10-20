package com.duberton.application.port

import com.duberton.application.domain.Person

interface FindPersonPort {

    fun findPersonById(id: String): Person?

}