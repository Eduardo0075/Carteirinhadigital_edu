package com.eduardosantos.carteirinhadigital2devest_b.feature.home_aluno.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.eduardosantos.carteirinhadigital2devest_b.app.navigation.Routes
import com.eduardosantos.carteirinhadigital2devest_b.feature.home_aluno.presentation.component.BotaoNavegacao

@Composable
fun HomeScreen(
    navController: NavController = NavController(
        LocalContext.current
    ),
    nomeAluno: String = "Eduardo Santos",
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(vertical = 24.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Olá, $nomeAluno!",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = "Seja bem-vindo ao portal da sua Carteirinha Digital",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(32.dp))

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BotaoNavegacao(
                "Carteirinha Digital",
                {
                    navController.navigate(Routes.Carteirinha.route)
                },
                modifier = Modifier
                    .fillMaxWidth(.8f)
                    .padding(vertical = 8.dp)
            )
            BotaoNavegacao(
                "Unidades Curriculares",
                {
                    navController.navigate(Routes.UCAluno.route)
                },
                modifier = Modifier
                    .fillMaxWidth(.8f)
                    .padding(vertical = 8.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
    )
}