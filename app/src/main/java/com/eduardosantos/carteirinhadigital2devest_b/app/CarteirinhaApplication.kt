package com.eduardosantos.carteirinhadigital2devest_b.app

import android.app.Application
import com.eduardosantos.carteirinhadigital2devest_b.app.di.AppContainer
import com.eduardosantos.carteirinhadigital2devest_b.app.di.DefaultAppContainer

class CarteirinhaApplication : Application() {
    val container: AppContainer by lazy {
        DefaultAppContainer()
    }
}