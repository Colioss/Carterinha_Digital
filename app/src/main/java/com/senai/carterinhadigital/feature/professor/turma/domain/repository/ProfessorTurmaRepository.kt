package com.senai.carterinhadigital.feature.professor.turma.domain.repository

import com.senai.carterinhadigital.feature.professor.turma.domain.model.Turma

interface ProfessorTurmaRepository {
    suspend fun listarTurmas(): Result<List<Turma>>
}
