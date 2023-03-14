package com.example.top3.dto

import com.example.top3.domain.Top3
import java.time.LocalDate

data class Top3Dto(
    val id: Long,
    val createdAt: LocalDate,
    val todos: List<TodoDto>
) {
    fun toEntity(): Top3 {
        val top3 = Top3(id = id, createdAt = createdAt)
        todos.map { top3.todos += it.toEntity(top3) }
        return top3
    }
}