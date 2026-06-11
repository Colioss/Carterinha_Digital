package com.senai.carterinhadigital.feature.home.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun homeScreen(
    onCarteirinhaClick: () -> Unit,
    onUnidadeCurricularClick: () -> Unit
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Bem-vindo, Usuário.", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = onCarteirinhaClick,modifier = Modifier.size(width = 200.dp, height = 60.dp, ), shape = RoundedCornerShape(16.dp) ) {
                Text("Ir para Carteirinha", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }


            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = onUnidadeCurricularClick,    modifier = Modifier.size(width = 200.dp, height = 60.dp), shape = RoundedCornerShape(16.dp) ) {
                Text(text = "Ir para Unidades Curriculares", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}