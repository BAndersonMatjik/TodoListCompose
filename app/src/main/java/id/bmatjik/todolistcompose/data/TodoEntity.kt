package id.bmatjik.todolistcompose.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_entity")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    val id:String,
    val title:String,
    val content:String,
    val createdDate:String,
    val colorItem:String,
    val pinned:Boolean=false
)
