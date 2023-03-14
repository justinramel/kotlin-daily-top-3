package com.example.top3.controllers

import com.example.top3.dao.Top3Repository
import com.example.top3.domain.Top3
import com.example.top3.dto.Top3Dto
import jakarta.persistence.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/top3")
class Top3Controller(private val top3Repository: Top3Repository) {
    @GetMapping
    fun findAll(): Top3Dto? = top3Repository.findByCreatedAt(LocalDate.now()).toDto()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody top3Dto: Top3Dto): Top3Dto {
        val top3 = Top3()
        top3Dto.todos.map { top3.todos += it.toEntity(top3) }.toMutableList()
        return top3Repository.save(top3).toDto()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody top3Dto: Top3Dto): Top3 {
        val existingTop3 = top3Repository.findById(id).orElseThrow { EntityNotFoundException() }
        val updatedTodos = top3Dto.todos.map { it.toEntity(existingTop3) }.toMutableList()
        val updatedTop3 = existingTop3.copy(todos = updatedTodos)
        return top3Repository.save(updatedTop3)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        top3Repository.deleteById(id)
    }
}