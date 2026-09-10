package pe.com.soda.testapp.data.mappers

import pe.com.soda.testapp.domain.model.Category

fun String.toDomain(): Category {
    return Category(
        name = this
    )
}