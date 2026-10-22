package com.senai.carterinhadigital.feature.aluno.unidadecurricular.data.remote.service

import com.senai.carterinhadigital.feature.aluno.unidadecurricular.data.remote.dto.UnidadeCurricularDto
import retrofit2.http.GET


interface UnidadeCurricularApi {

    @GET("unidades-curriculares")
    suspend fun listar(): List<UnidadeCurricularDto>
}