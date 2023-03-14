package com.example.top3.domain

import com.example.top3.dto.TodoDto
import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(name = "todo")
data class Todo(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "title", nullable = false)
    val title: String,

    @Column(name = "complete", nullable = false)
    var complete: Boolean,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "top3_id")
    @JsonBackReference
    var top3: Top3
) {
    fun toDto(): TodoDto = TodoDto(id = id, title = title, complete = complete)
}