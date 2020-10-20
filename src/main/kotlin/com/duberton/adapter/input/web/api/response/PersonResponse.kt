package com.duberton.adapter.input.web.api.response

data class PersonResponse(
    val name: String,
    val type: String,
    val createdAt: String,
    val document: Document
) {

    data class Document(
        val number: String
    )
}