package com.eduardosantos.carteirinhadigital2devest_b.app.di

import com.eduardosantos.carteirinhadigital2devest_b.core.auth.AuthTokenStore
import com.eduardosantos.carteirinhadigital2devest_b.feature.login.data.repository.LoginRepository
import com.eduardosantos.carteirinhadigital2devest_b.feature.unidadecurriculares.domain.repository.UnidadeCurricularRepository

interface AppContainer {

    val loginRepository: LoginRepository

    val unidadeCurricularRepository: UnidadeCurricularRepository

    val authTokenStore: AuthTokenStore
}