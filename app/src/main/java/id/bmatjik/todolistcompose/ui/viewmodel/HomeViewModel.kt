package id.bmatjik.todolistcompose.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.bmatjik.todolistcompose.domain.model.Todo
import id.bmatjik.todolistcompose.domain.repository.TodoRepository
import id.bmatjik.todolistcompose.ui.navigation.Screen
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val todoRepository: TodoRepository
): BaseComposeViewModel<HomeUiEvent>() {
    val homeUiState = mutableStateOf<HomeUiState>(HomeUiState())
    override fun onStateEvent(onUiEvent: HomeUiEvent) {
        when(onUiEvent){
            is HomeUiEvent.FetchTodos->{
                homeUiState.value = homeUiState.value.copy(todos = listOf(
                    Todo(
                        id = "zzz",
                        title = "My Day",
                        content = "Shalalalalalalalalalalallaalla",
                        created_date = "21-12-2022",
                        colorItem = "#ffff",
                        pinned = false
                    )
                ))

            }
            is HomeUiEvent.DeleteTodo->{

            }
            else ->{
               homeUiState.value =  homeUiState.value.copy(errorMessage = "Ui Event Not Register in ${HomeUiEvent::class.java.`package`}")
            }
        }
    }
}

abstract class BaseComposeViewModel<T:UiEvent>():ViewModel(){
    abstract fun onStateEvent(onUiEvent: T)
}


data class HomeUiState(
    val loading: Boolean = false,
    val todos:List<Todo> = listOf(),
    val errorMessage:String = ""
)

sealed interface UiEvent

sealed interface HomeUiEvent:UiEvent{
    object FetchTodos: HomeUiEvent
    object test:HomeUiEvent
    data class DeleteTodo(val todo: Todo): HomeUiEvent
}
