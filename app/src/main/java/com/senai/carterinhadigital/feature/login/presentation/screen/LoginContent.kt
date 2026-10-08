package com.senai.carterinhadigital.feature.login.presentation.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senai.carterinhadigital.R
import com.senai.carterinhadigital.feature.login.presentation.LoginEvent
import com.senai.carterinhadigital.feature.login.presentation.LoginUiState

@Composable
fun LoginContent(
    modifier: Modifier = Modifier,
    uiState: LoginUiState,
    onEvent: (LoginEvent) -> Unit,
    darkTheme: Boolean,
    onDarkThemeChange: (Boolean) -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        IconButton(
            onClick = {
                onDarkThemeChange(!darkTheme)
            },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 24.dp, end = 16.dp)
        ) {
            Text(
                text = if (darkTheme) "☀" else "☾",
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logosenai),
                contentDescription = "Logo SENAI",
                contentScale = ContentScale.Fit,
                modifier = Modifier.width(150.dp)
            )

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "Login",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(18.dp))

            TextField(
                value = uiState.usuario,
                onValueChange = { value ->
                    onEvent(LoginEvent.OnUsuarioChange(value))
                },
                label = {
                    Text("Usuário")
                },
                modifier = Modifier.fillMaxWidth(0.70f)
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = uiState.senha,
                onValueChange = { value ->
                    onEvent(LoginEvent.OnSenhaChange(value))
                },
                label = {
                    Text("Senha")
                },
                modifier = Modifier.fillMaxWidth(0.70f)
            )

            Spacer(modifier = Modifier.height(14.dp))

            Button(
                onClick = {
                    onEvent(LoginEvent.OnEntrarClick)
                },
                enabled = !uiState.isLoading,
                shape = RoundedCornerShape(4.dp),
                border = BorderStroke(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.onBackground
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE30613),
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth(0.55f)
            ) {
                if (uiState.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.width(20.dp),
                        strokeWidth = 2.dp,
                        color = Color.White
                    )
                } else {
                    Text(
                        text = "Entrar",
                        color = Color.White
                    )
                }
            }
        }
    }
}