package com.example.tasked

data class Todo(
    var id: Int,
    var title: String = "",
    var isCompleted: Boolean = false,
    var subtask: Boolean = false
)

    fun fetchDummyTodos(): List<Todo> {
        return listOf(
            Todo(1, "Task 1: Catch the flying pig, then eat it", false),
            Todo(2, "Task 2: Go to KFC and order 4 burgers with extra large fries for takeaway" , true),
            Todo(3, "Task 3: Finish pending assignments for Computer Organization", false),
            Todo(4, "Task 4: Take a bath, it's been over a month", true),
        )
    }