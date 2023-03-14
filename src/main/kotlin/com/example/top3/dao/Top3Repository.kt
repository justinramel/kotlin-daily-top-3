package com.example.top3.dao

import com.example.top3.domain.Top3
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate

interface Top3Repository : JpaRepository<Top3, Long> {
    fun findByCreatedAt(createdAt: LocalDate): Top3
}