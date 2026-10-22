package com.senai.carterinhadigital.feature.professor.turma.data.remote.service

import com.senai.carterinhadigital.feature.professor.turma.data.remote.dto.TurmaDto
import retrofit2.http.GET

interface ProfessorTurmaApi {
    @GET("professores/me/turmas")
    suspend fun listarTurmas(): List<TurmaDto>
}
