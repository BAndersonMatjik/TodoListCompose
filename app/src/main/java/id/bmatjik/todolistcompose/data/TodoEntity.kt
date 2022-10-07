package id.bmatjik.todolistcompose.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "todo_entity")
data class TodoEntity(
    @PrimaryKey
    val id:String=UUID.randomUUID().toString(),
    val title:String,
    val content:String,
    val createdDate:String,
    val colorItem:String,
    val pinned:Boolean=false
)
