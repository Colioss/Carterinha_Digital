package com.senai.carterinhadigital.feature.unidadecurricular.data.repository

import com.senai.carterinhadigital.feature.unidadecurricular.data.remote.service.UnidadeCurricularApi
import com.senai.carterinhadigital.feature.unidadecurricular.domain.model.UnidadeCurricular
import retrofit2.HttpException
import java.io.IOException

class ApiUnidadeCurricularRepositoryImpl(
    private val api: UnidadeCurricularApi
): UnidadeCurricularRepository {
   
    override suspend fun listarUnidades(token: String): Result<List<UnidadeCurricular>> {
        return runCatching {
            api.listar(authorization = "Bearer $token").map {
                it.toDomain()
            }
        }.recoverCatching { throwable ->
            throw when(throwable){
                is HttpException -> {
                    if(throwable.code() == 401){
                        IllegalStateException("Sua sessão expirou. Faça Login novamente")
                    } else{
                        IllegalStateException("Erro ao carregar unidades curriculares(${throwable.code()})")
                    }
                } 
                is IOException -> IllegalStateException("Não foi possível conectar a API")
                else -> IllegalStateException(throwable.message ?: "Erro ao carregar unidades curriculares")
            }
        }
    }
}
