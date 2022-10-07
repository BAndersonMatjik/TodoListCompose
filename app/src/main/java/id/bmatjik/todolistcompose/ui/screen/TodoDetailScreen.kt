package id.bmatjik.todolistcompose.ui.screen

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import id.bmatjik.todolistcompose.HomeScreen
import id.bmatjik.todolistcompose.R
import id.bmatjik.todolistcompose.ui.theme.TodoListComposeTheme
import id.bmatjik.todolistcompose.ui.utils.ScrollableTextField

@Composable
fun TodoDetailScreen(navController: NavController) {
//    var todoId get by argument
    var content by remember {
        mutableStateOf<String>("")
    }
    var title by remember {
        mutableStateOf("Title Set")
    }
    Box() {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 6.dp)) {
            BasicTextField(value = title, onValueChange = {
                                                     title = it
            }, textStyle = MaterialTheme.typography.titleLarge, singleLine = true,)
            Spacer(modifier = Modifier.height(6.dp))
            Column(modifier = Modifier.fillMaxSize()) {
                ScrollableTextField(content = content, onValueChange = {
                    content = it
                }, modifier = Modifier.background(Color.Blue))
            }
        }
        FloatingActionButton(onClick = { Log.d("TodoDetailScreen", "TodoDetailScreen: clicked") }, modifier = Modifier
            .align(
                Alignment.BottomEnd
            )
            .padding(8.dp)){
            Image(painter = painterResource(id = R.drawable.ic_add), contentDescription = "add todo list")
        }
    }

}

@Preview(showBackground = true, device = Devices.PIXEL_2)
@Composable
fun TodoDetailPreview() {
    TodoListComposeTheme {
        TodoDetailScreen()
    }
}