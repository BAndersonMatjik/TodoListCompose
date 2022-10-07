package id.bmatjik.todolistcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import id.bmatjik.todolistcompose.domain.model.Todo
import id.bmatjik.todolistcompose.ui.theme.TodoListComposeTheme
import java.time.LocalDateTime
import java.time.OffsetDateTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoListComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Todo", style = MaterialTheme.typography.titleLarge)
        LazyColumn(content = {

        })
    }
}

@Composable
fun TodoItem(todo: Todo){
    Column(modifier = Modifier.fillMaxWidth()) {
        Row() {
            Text(text = todo.title)
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_2)
@Composable
fun DefaultPreview() {
    TodoListComposeTheme {
        HomeScreen()
    }
}

@Preview
@Composable
fun TodoItemPreview(
) {
    TodoListComposeTheme {
        TodoItem(Todo(
            id = "1234567",
            title = "Hello World",
            content = "as today i do something worse because i get forget about xml.",
            created_date = LocalDateTime.now().toInstant(OffsetDateTime.now().offset).toString(),
            colorItem = "#fff",
            pinned = false
        ))
    }
}
