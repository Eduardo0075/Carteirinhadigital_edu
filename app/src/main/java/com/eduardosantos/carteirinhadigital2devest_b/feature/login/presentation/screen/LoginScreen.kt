package com.eduardosantos.carteirinhadigital2devest_b.feature.login.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.eduardosantos.carteirinhadigital2devest_b.R
import com.eduardosantos.carteirinhadigital2devest_b.feature.login.domain.model.UsuarioLogado
import com.eduardosantos.carteirinhadigital2devest_b.feature.login.presentation.LoginEvent
import com.eduardosantos.carteirinhadigital2devest_b.feature.login.presentation.LoginViewModel
import androidx.compose.foundation.background
import com.eduardosantos.carteirinhadigital2devest_b.core.designsystem.theme.errorLight
import com.eduardosantos.carteirinhadigital2devest_b.core.designsystem.theme.primaryDark
import androidx.compose.material3.OutlinedTextFieldDefaults

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController = NavController(
        LocalContext.current
    ),
    viewModel: LoginViewModel = viewModel(),
    onLoginSucesso:(UsuarioLogado)-> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(uiState.usuarioLogado) {
        uiState.usuarioLogado?.let { usuario ->
            viewModel.onEvent(LoginEvent.OnNavegacaoRealizada)
            onLoginSucesso(usuario)
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(errorLight)
            .padding(24.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo Carteirinha Digital",
            modifier = Modifier
                .fillMaxWidth(0.65f)
                .padding(bottom = 16.dp)
        )

        Text(
            text = "Acesso ao Sistema",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = uiState.usuario,
            onValueChange = { value ->
                viewModel.onEvent(LoginEvent.OnUsuarioChange(value))
            },
            label = {
                Text(text = "Usuário / E-mail")
            },
            singleLine = true,
            isError = uiState.erroMessage != null,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = primaryDark,
                unfocusedBorderColor = primaryDark,
                focusedLabelColor = primaryDark,
                unfocusedLabelColor = primaryDark,
                cursorColor = primaryDark,
                focusedTextColor = primaryDark,
                unfocusedTextColor = primaryDark,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth(0.85f)
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = uiState.senha,
            onValueChange = { value ->
                viewModel.onEvent(LoginEvent.OnSenhaChange(value))
            },
            label = {
                Text(text = "Senha")
            },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            isError = uiState.erroMessage != null,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = primaryDark,
                cursorColor = primaryDark,
                focusedTextColor = primaryDark,
                unfocusedTextColor = primaryDark,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth(0.85f)
        )

        uiState.erroMessage?.let { error ->
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = error,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.fillMaxWidth(0.85f)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                viewModel.onEvent(LoginEvent.OnEntrarClick)
            },
            enabled = !uiState.isLoading,
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(48.dp)
        ) {
            if (uiState.isLoading) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(24.dp)
                )
            } else {
                Text(
                    text = "Entrar",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}