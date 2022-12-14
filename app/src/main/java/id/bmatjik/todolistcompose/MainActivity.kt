package id.bmatjik.todolistcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import dagger.hilt.android.AndroidEntryPoint
import id.bmatjik.todolistcompose.domain.model.Todo
import id.bmatjik.todolistcompose.ui.navigation.BaseNavigationScreen
import id.bmatjik.todolistcompose.ui.navigation.Screen
import id.bmatjik.todolistcompose.ui.theme.TodoListComposeTheme
import id.bmatjik.todolistcompose.ui.viewmodel.HomeUiEvent
import id.bmatjik.todolistcompose.ui.viewmodel.HomeViewModel
import java.time.LocalDateTime
import java.time.OffsetDateTime

@AndroidEntryPoint
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
                    BaseNavigationScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    var isMadeByTextVisible by remember { mutableStateOf(false) }
    var uiState by remember {
        viewModel.homeUiState
    }
    LaunchedEffect(key1 = uiState ){
        viewModel.onStateEvent(HomeUiEvent.FetchTodos)
    }
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 6.dp)
        ) {
            Text(
                text = "Todo",
                style = MaterialTheme.typography.headlineMedium,
                fontSize = 30.sp,
                modifier = Modifier.clickable {
                    isMadeByTextVisible = !isMadeByTextVisible
                })
            AnimatedVisibility(visible = isMadeByTextVisible) {
                Text(
                    text = "Made By BAndersonMatjik",
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 14.sp
                )
            }
            LazyColumn(content = {
                items(uiState.todos, itemContent = {item->
                    TodoItem(todo = item, modifier = Modifier.clickable {
                        navController.navigate(Screen.Detail.route)
                    })
                })
            })
        }
        FloatingActionButton(onClick = { navController.navigate(Screen.Detail.route) }, modifier = Modifier
            .align(
                Alignment.BottomEnd
            )
            .padding(8.dp)){
            Image(painter = painterResource(id = R.drawable.ic_add), contentDescription = "add todo list")
        }
    }
}

@Composable
fun TodoItem(todo: Todo,modifier: Modifier=Modifier) {
    Card(shape = RoundedCornerShape(20.dp), modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 6.dp)
        ) {
            Row() {
                Text(text = todo.title, style = MaterialTheme.typography.titleSmall)
                Spacer(Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.ic_pin),
                    contentDescription = "Pin Card"
                )
            }
            Text(text = todo.content.take(300), style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_2)
@Composable
fun DefaultPreview() {
    TodoListComposeTheme {
    }
}

@Preview(showBackground = true)
@Composable
fun TodoItemPreview(
) {
    TodoListComposeTheme {
        TodoItem(
            Todo(
                id = "1234567",
                title = "Hello World",
                content = "as today i do something worse because i get forget about xml.as today i do something worse because i get forget about xml.",
                created_date = LocalDateTime.now().toInstant(OffsetDateTime.now().offset)
                    .toString(),
                colorItem = "#fff",
                pinned = false
            )
        )
    }
}


