package id.bmatjik.todolistcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        Text(text = "Todo", style = MaterialTheme.typography.titleLarge, fontSize = 30.sp)
        LazyColumn(content = {

        })
    }
}

@Composable
fun TodoItem(todo: Todo){
    Card(shape = RoundedCornerShape(20.dp)){
        Column(modifier = Modifier.fillMaxWidth().padding(6.dp)) {
            Row() {
                Text(text = todo.title, style = MaterialTheme.typography.titleSmall)
                Spacer(Modifier.weight(1f))
                Image(painter = painterResource(id = R.drawable.ic_pin), contentDescription = "Pin Card")
            }
           Text(text = todo.content.take(300), style = MaterialTheme.typography.bodySmall)
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

@Preview(showBackground = true)
@Composable
fun TodoItemPreview(
) {
    TodoListComposeTheme {
        TodoItem(Todo(
            id = "1234567",
            title = "Hello World",
            content = "as today i do something worse because i get forget about xml.as today i do something worse because i get forget about xml.",
            created_date = LocalDateTime.now().toInstant(OffsetDateTime.now().offset).toString(),
            colorItem = "#fff",
            pinned = false
        ))
    }
}


