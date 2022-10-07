package id.bmatjik.todolistcompose.domain.model

data class Todo(
    val id:String,
    val title:String,
    val content:String,
    val created_date:String,
    val colorItem:String,
    val pinned:Boolean=false
)