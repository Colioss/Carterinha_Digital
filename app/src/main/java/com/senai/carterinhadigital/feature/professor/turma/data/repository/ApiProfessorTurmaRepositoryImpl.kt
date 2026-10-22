package com.senai.carterinhadigital.feature.professor.turma.data.repository

import com.senai.carterinhadigital.feature.professor.turma.data.remote.service.ProfessorTurmaApi
import com.senai.carterinhadigital.feature.professor.turma.domain.model.Turma
import com.senai.carterinhadigital.feature.professor.turma.domain.repository.ProfessorTurmaRepository
import retrofit2.HttpException
import java.io.IOException

class ApiProfessorTurmaRepositoryImpl(
    private val api: ProfessorTurmaApi
) : ProfessorTurmaRepository {

    override suspend fun listarTurmas(): Result<List<Turma>> {
        return runCatching {
            api.listarTurmas().map { it.toDomain() }
        }.recoverCatching { throwable ->
            throw when (throwable) {
                is HttpException -> {
                    if (throwable.code() == 401) {
                        IllegalStateException("Sua sessão expirou. Faça login novamente.")
                    } else {
                        IllegalStateException("Erro ao carregar turmas (${throwable.code()}).")
                    }
                }
                is IOException ->
                    IllegalStateException("Não foi possível conectar à API.")
                else ->
                    IllegalStateException(throwable.message ?: "Erro ao carregar turmas.")
            }
        }
    }
}
