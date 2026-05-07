package com.senai.carterinhadigital.feature.auth.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.senai.carterinhadigital.app.navigation.Routes
import com.senai.carterinhadigital.core.designsystem.theme.CarteirinhaDigitalTheme


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var login by remember { mutableStateOf("") };
    var senha by remember { mutableStateOf("") };
    var erro by remember { mutableStateOf(false)};
    var email by remember {mutableStateOf("Email")};
    var emailsenha by remember{mutableStateOf("Senha")}
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login")
        TextField(
            value = login,
            onValueChange = { login = it
                            erro = false
                            email = "Email"
                            emailsenha = "Senha"},
            label = { Text(email) },
            isError = erro
        )

        OutlinedTextField(

            value = senha,
            onValueChange = { senha = it
                              erro = false
                              email = "Email"
                              emailsenha = "Senha"},
            label = { Text(emailsenha) },
            isError = erro

        )
        Button(
            onClick = {
                if (login == "admin" && senha == "1234") {
                    erro = false
                    navController.navigate(Routes.Carteirinha)

                } else {
                    erro = true
                    email = "Email ou Senha incorretos"
                    emailsenha = email


                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = Modifier
                .width(200.dp),
            shape = RoundedCornerShape(size = 5.dp),
            border = BorderStroke(
                width = 4.dp,
                color = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Text("Entrar")
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun LoginScreenPreviewDark() {
    CarteirinhaDigitalTheme(
        darkTheme = true
    ) {
        //  LoginScreen()
    }

}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun LoginScreenPreview() {
    CarteirinhaDigitalTheme(
        darkTheme = false
    ) {
        //LoginScreen()
    }

}