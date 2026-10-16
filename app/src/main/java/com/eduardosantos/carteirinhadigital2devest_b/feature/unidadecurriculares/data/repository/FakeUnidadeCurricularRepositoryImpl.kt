package com.eduardosantos.carteirinhadigital2devest_b.feature.unidadecurriculares.data.repository

import com.eduardosantos.carteirinhadigital2devest_b.feature.unidadecurriculares.data.dataSource
import com.eduardosantos.carteirinhadigital2devest_b.feature.unidadecurriculares.domain.model.UnidadeCurricular
import com.eduardosantos.carteirinhadigital2devest_b.feature.unidadecurriculares.domain.repository.UnidadeCurricularRepository
import kotlinx.coroutines.delay

class FakeUnidadeCurricularRepositoryImpl : UnidadeCurricularRepository {
    override suspend fun listarUnidadesCurriculares(): Result<List<UnidadeCurricular>> {
        delay(800)
        return Result.success(dataSource())
    }
}
