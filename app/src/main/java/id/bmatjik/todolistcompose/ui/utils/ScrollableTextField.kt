package id.bmatjik.todolistcompose.ui.utils

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun ScrollableTextField(content: String,onValueChange : (String) -> Unit,modifier: Modifier=Modifier) {
    var offset by remember { mutableStateOf(0f) }
    BasicTextField(modifier = modifier
        .fillMaxSize()
        .scrollable(
            orientation = Orientation.Vertical,
            state = rememberScrollableState { delta ->
                offset += delta
                delta
            }
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        value = content,
        onValueChange = onValueChange
    )
}