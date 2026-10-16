package com.eduardosantos.carteirinhadigital2devest_b.app.di

import com.eduardosantos.carteirinhadigital2devest_b.core.auth.AuthTokenStore
import com.eduardosantos.carteirinhadigital2devest_b.core.auth.InMemoryAuthTokenStore
import com.eduardosantos.carteirinhadigital2devest_b.core.network.NetworkClient
import com.eduardosantos.carteirinhadigital2devest_b.feature.login.data.remote.service.AuthApi
import com.eduardosantos.carteirinhadigital2devest_b.feature.login.data.repository.ApiLoginRepositoryImpl
import com.eduardosantos.carteirinhadigital2devest_b.feature.login.data.repository.FakeLoginRepositoryImpl
import com.eduardosantos.carteirinhadigital2devest_b.feature.login.data.repository.LoginRepository
import com.eduardosantos.carteirinhadigital2devest_b.feature.unidadecurriculares.data.remote.service.UnidadeCurricularApi
import com.eduardosantos.carteirinhadigital2devest_b.feature.unidadecurriculares.data.repository.ApiUnidadeCurricularRepositoryImpl
import com.eduardosantos.carteirinhadigital2devest_b.feature.unidadecurriculares.data.repository.FakeUnidadeCurricularRepositoryImpl
import com.eduardosantos.carteirinhadigital2devest_b.feature.unidadecurriculares.domain.repository.UnidadeCurricularRepository

class DefaultAppContainer : AppContainer {

    override val authTokenStore: AuthTokenStore = InMemoryAuthTokenStore()
    private val publicNetworkClient = NetworkClient(baseUrl = BASE_URL)

    private val authenticatedNetworkClient = NetworkClient(
        baseUrl = BASE_URL,
        authTokenStore = authTokenStore
    )

    private val authApi: AuthApi by lazy {
        publicNetworkClient.create(AuthApi::class.java)
    }

    private val unidadeCurricularApi: UnidadeCurricularApi by lazy {
        authenticatedNetworkClient.create(UnidadeCurricularApi::class.java)
    }

    override val loginRepository: LoginRepository by lazy {
        if (USE_FAKE_REPOSITORY) {
            FakeLoginRepositoryImpl()
        } else {
            ApiLoginRepositoryImpl(api = authApi)
        }
    }

    override val unidadeCurricularRepository: UnidadeCurricularRepository by lazy {
        if (USE_FAKE_REPOSITORY) {
            FakeUnidadeCurricularRepositoryImpl()
        } else {
            ApiUnidadeCurricularRepositoryImpl(api = unidadeCurricularApi)
        }
    }

    companion object {
        private const val BASE_URL = "http://10.0.2.2:8080/"
        // Define se utiliza repositórios locais (fakes) para testes isolados sem backend
        private const val USE_FAKE_REPOSITORY = true
    }
}