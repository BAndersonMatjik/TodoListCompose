package id.bmatjik.todolistcompose.data.mapper

import id.bmatjik.todolistcompose.data.TodoEntity
import id.bmatjik.todolistcompose.domain.model.Todo

fun TodoEntity.toDomain()= Todo(
    id = id,
    title = title,
    content = content,
    created_date = createdDate,
    colorItem = colorItem,
    pinned = pinned
)
fun Todo.toEntity()= TodoEntity(
    title = title,
    content = content,
    createdDate = created_date,
    colorItem = colorItem,
    pinned = pinned
)