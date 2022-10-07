package id.bmatjik.todolistcompose.domain.repository

import id.bmatjik.todolistcompose.domain.model.Todo

interface TodoRepository {
    suspend fun getTodos():List<Todo>
    suspend fun getTodo(id:String):Todo
    suspend fun getTodoByTitle(title:String):List<Todo>
    suspend fun add(todo:Todo)
    suspend fun update(todo: Todo)
    suspend fun delete(todo: Todo)
}