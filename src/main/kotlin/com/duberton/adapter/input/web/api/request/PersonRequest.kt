package com.duberton.adapter.input.web.api.request

data class PersonRequest(
    val name: String,
    val type: String,
    val document: Document
) {

    data class Document(
        val number: String
    )
}