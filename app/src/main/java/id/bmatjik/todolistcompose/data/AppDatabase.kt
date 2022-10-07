package id.bmatjik.todolistcompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import id.bmatjik.todolistcompose.data.local.TodoDao

@Database(version = 1, entities = [TodoEntity::class])
abstract class AppDatabase: RoomDatabase(){
    abstract fun todoDao():TodoDao
}