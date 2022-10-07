package id.bmatjik.todolistcompose.data.local

import androidx.room.*
import id.bmatjik.todolistcompose.data.TodoEntity
import id.bmatjik.todolistcompose.domain.model.Todo

@Dao
interface TodoDao {

    @Insert
    suspend fun insertAll(vararg todos: TodoEntity)

    @Update
    suspend fun updateAll(vararg todos: TodoEntity)

    @Delete
    suspend fun delete(todo: TodoEntity)

    @Query("SELECT * FROM todo_entity")
    suspend fun getAll(): List<TodoEntity>
}