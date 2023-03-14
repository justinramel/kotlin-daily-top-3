package com.example.top3.dao

import com.example.top3.domain.Top3
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.lang.Nullable
import java.time.LocalDate

interface Top3Repository : JpaRepository<Top3, Long> {
    @Nullable
    fun findByCreatedAt(createdAt: LocalDate): Top3
}