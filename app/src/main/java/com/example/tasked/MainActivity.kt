package com.example.tasked

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasked.ui.theme.TaskedTheme
import com.example.tasked.ui.theme.nueFont


val primary_black = Color(0xFF111111)
val secondary_black = Color(0xFF222222)
val shade_red = Color(0xFFFF5A60)
var presses = 0

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            TaskedTheme {
                ScaffoldExample()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
//                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = shade_red,
                ),
                title = {
                    Text("tasked",
                        fontFamily = nueFont,
                        fontSize = 36.sp)
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { presses++ },
                containerColor = shade_red,
                contentColor = Color.Black) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            TodoView()
        }
    }
}

@Composable
fun TodoView(modifier: Modifier = Modifier) {
    val dummy = fetchDummyTodos()
    Column(modifier = Modifier
        .fillMaxHeight()
        .padding(horizontal = 14.dp)) {
        LazyColumn(
            modifier = Modifier.padding(vertical = 4.dp),
            content = {itemsIndexed(dummy){
                index: Int, item: Todo ->
                TodoItemModifier(item)
            } }
        )

    }
}

@Composable
fun TodoItemModifier(item: Todo) {

    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Checkbox(
            checked = item.isCompleted,
            onCheckedChange = {!item.isCompleted},
            colors = CheckboxDefaults.colors(shade_red)
        )
        Text(modifier = Modifier.padding(vertical = 4.dp),
            text = item.title.toString(), fontFamily = nueFont)

    }
}

@Composable
fun AddTaskBtn(onClick: () -> Unit) {
    FloatingActionButton(
        // align the fab to bottom right
        onClick = onClick,
        shape = CircleShape,
        containerColor = Color.Red,

    ) {
        Icon(Icons.Filled.Add, contentDescription = "Add Task")
    }
}

@Preview
@Composable
fun PreviewTodos(){
    TodoView()
}