package com.eduardosantos.carteirinhadigital2devest_b.feature.carteirinha.presetantion.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.eduardosantos.carteirinhadigital2devest_b.R
import com.eduardosantos.carteirinhadigital2devest_b.feature.carteirinha.presetantion.component.PerfilAluno
import com.eduardosantos.carteirinhadigital2devest_b.feature.carteirinha.presetantion.component.QrCode

@Composable
fun CarteirinhaScreen(
    modifier: Modifier = Modifier,
    nome: String = "Eduardo Santos",
    curso: String = "Desenvolvimento de Sistemas",
    qrContent: String = "SENAI-CARTEIRINHA-EDUARDO-SANTOS-2DEVEST-B"
) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.fundo),
            contentDescription = "Fundo",
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.5f),
            contentScale = ContentScale.Crop
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Senai",
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            PerfilAluno(
                nome = nome,
                curso = curso
            )
            QrCode(
                conteudo = qrContent
            )
        }
    }
}