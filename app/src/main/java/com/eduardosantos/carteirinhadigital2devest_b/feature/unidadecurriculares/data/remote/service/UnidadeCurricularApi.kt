package com.eduardosantos.carteirinhadigital2devest_b.feature.unidadecurriculares.data.remote.service

import com.eduardosantos.carteirinhadigital2devest_b.feature.unidadecurriculares.data.remote.dto.UnidadeCurricularDTO
import retrofit2.http.GET

interface UnidadeCurricularApi {

    @GET("unidades-curriculares")
    suspend fun listarUnidadesCurriculares():
        List<UnidadeCurricularDTO>
}