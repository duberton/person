package com.duberton.adapter.output.mongodb.entity

data class PersonEntity(
    var _id: String? = null,
    var name: String? = null,
    var type: String? = null,
    var createdAt: String? = null,
    var document: Document? = null
) {

    data class Document(
        var number: String? = null
    )

}