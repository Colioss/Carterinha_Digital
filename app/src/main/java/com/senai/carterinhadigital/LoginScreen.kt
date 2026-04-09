package com.senai.carterinhadigital

import CarteirinhaScreen
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.senai.carterinhadigital.ui.theme.CarteirinhaDigitalTheme


@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login")
            TextField(
                value = "",
                onValueChange = {},
                label = {Text("Email")}
            )

        OutlinedTextField(

                value = "",
                onValueChange = {},
                label = { Text("senha")}
        )
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = Modifier
                .width(200.dp),
            shape = RoundedCornerShape( size = 5.dp),
            border = BorderStroke (
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
        LoginScreen()
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
        LoginScreen()
    }

}