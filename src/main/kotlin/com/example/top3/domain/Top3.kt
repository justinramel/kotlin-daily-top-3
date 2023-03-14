package com.example.top3.domain

import com.example.top3.dto.Top3Dto
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "top3")
data class Top3(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDate = LocalDate.now(),

    @OneToMany(mappedBy = "top3", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonManagedReference
    val todos: MutableList<Todo> = mutableListOf(),
    )
{
    fun toDto(): Top3Dto = Top3Dto(id = id, createdAt = createdAt, todos = todos.map { it.toDto() })
}