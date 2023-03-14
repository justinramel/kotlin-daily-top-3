package com.example.top3.dto

import com.example.top3.domain.Todo
import com.example.top3.domain.Top3

data class TodoDto(
    val id: Long,
    val title: String,
    val complete: Boolean
) {
    fun toEntity(top3: Top3) : Todo = Todo(id = id, title = title, complete = complete, top3 = top3)
}