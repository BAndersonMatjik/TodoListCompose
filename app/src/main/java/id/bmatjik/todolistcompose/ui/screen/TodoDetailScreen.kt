package id.bmatjik.todolistcompose.ui.screen

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.bmatjik.todolistcompose.HomeScreen
import id.bmatjik.todolistcompose.R
import id.bmatjik.todolistcompose.ui.theme.TodoListComposeTheme
import id.bmatjik.todolistcompose.ui.utils.ScrollableTextField

@Composable
fun TodoDetailScreen(todoId: String) {
    var content by remember {
        mutableStateOf<String>("")
    }
    Box() {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 6.dp)) {
            Text(text = "Todo", style = MaterialTheme.typography.titleLarge, fontSize = 30.sp)
            Spacer(modifier = Modifier.height(6.dp))
            Column(modifier = Modifier.fillMaxSize()) {
                ScrollableTextField(content = content, onValueChange = {
                    content = it
                })
            }
        }
        FloatingActionButton(onClick = { Log.d("TodoDetailScreen", "TodoDetailScreen: clicked") }, modifier = Modifier.align(
            Alignment.BottomEnd).padding(8.dp)){
            Image(painter = painterResource(id = R.drawable.ic_add), contentDescription = "add todo list")
        }
    }

}

@Preview(showBackground = true, device = Devices.PIXEL_2)
@Composable
fun TodoDetailPreview() {
    TodoListComposeTheme {
        TodoDetailScreen("AAAAA")
    }
}