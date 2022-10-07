package id.bmatjik.todolistcompose.data.repository

import id.bmatjik.todolistcompose.data.local.TodoDao
import id.bmatjik.todolistcompose.data.mapper.toDomain
import id.bmatjik.todolistcompose.data.mapper.toEntity
import id.bmatjik.todolistcompose.domain.model.Todo
import id.bmatjik.todolistcompose.domain.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoRepositoryImpl @Inject constructor(
    private val todoDao: TodoDao
): TodoRepository {
    override suspend fun getTodos(): List<Todo> {
        return withContext(Dispatchers.IO){
            todoDao.getAll().map {
                it.toDomain()
            }
        }
    }

    override suspend fun getTodo(id: String): Todo {
        return withContext(Dispatchers.IO){
            todoDao.getAll().filter { it.id==id  }.map { it.toDomain() }.firstOrNull()?:throw NullPointerException("Todo with id $id not found in local database")
        }
    }

    override suspend fun getTodoByTitle(title: String): List<Todo> {
        return withContext(Dispatchers.IO){
            todoDao.getAll().filter { it.title.equals(title,true) }.map { it.toDomain() }
        }
    }

    override suspend fun add(todo: Todo) {
        return withContext(Dispatchers.IO){
            todoDao.insertAll(todo.toEntity())
        }
    }

    override suspend fun update(todo: Todo) {
        return withContext(Dispatchers.IO){
            todoDao.updateAll(todo.toEntity())
        }
    }

    override suspend fun delete(todo: Todo) {
        return withContext(Dispatchers.IO){
            todoDao.delete(todo.toEntity())
        }
    }
}