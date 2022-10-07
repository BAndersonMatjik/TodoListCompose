package id.bmatjik.todolistcompose.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.bmatjik.todolistcompose.data.AppDatabase
import id.bmatjik.todolistcompose.data.local.TodoDao
import id.bmatjik.todolistcompose.data.repository.TodoRepositoryImpl
import id.bmatjik.todolistcompose.domain.repository.TodoRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun providesDb(@ApplicationContext context:Context):AppDatabase=
        Room.databaseBuilder(context, AppDatabase::class.java, "todo.db")
            .build()

    @Provides
    @Singleton
    fun provideTodoDao(appDatabase: AppDatabase):TodoDao=appDatabase.todoDao()

}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTodoRepository(todoRepositoryImpl: TodoRepositoryImpl):TodoRepository

}