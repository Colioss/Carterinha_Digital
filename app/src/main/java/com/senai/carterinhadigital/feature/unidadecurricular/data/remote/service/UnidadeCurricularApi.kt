package com.senai.carterinhadigital.feature.unidadecurricular.data.remote.service

import com.senai.carterinhadigital.feature.unidadecurricular.data.remote.dto.UnidadeCurricularDTO
import retrofit2.http.GET
import retrofit2.http.Header

interface UnidadeCurricularApi {
    @GET("unidades-curriculares")
    suspend fun listar(
        @Header("Authorization")
        authorization:String
    ): List<UnidadeCurricularDTO>
}