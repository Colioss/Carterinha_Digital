package com.senai.carterinhadigital

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rafaelcosta.carteirinhadigital_4devm_t1.feature.carteirinha.presentation.component.QrCode
import com.senai.carterinhadigital.ui.theme.CarterinhaDigitalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarterinhaDigitalTheme {
                Scaffold{
                    innerPadding ->
                    CarterinhaDigitalApp(
                        modifier = Modifier
                            .padding( paddingValues = innerPadding)
                            .fillMaxSize()
                    )
                }

            }
        }
    }
}


@Composable
fun CarterinhaDigitalApp(modifier: Modifier = Modifier) {
    Box{
        Image(
            painter = painterResource(id = R.drawable.fundo),
            contentDescription = "Fundo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()

        )
    Column(
        modifier=modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "Aluno",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    Color.Red
                )
        )
        Image(
            painter = painterResource(R.drawable.pantera),
            contentDescription = null
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Nome:")
            Text(text = "Emanu")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Curso:")
            Text(text = "Desenvolvimento De Sistemas")
        }

        QrCode(
            conteudo = "90000000001771684443",
            modifier = Modifier
                .border(
                    width = 2.dp,
                    Color.Red
                )
        )
      }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CarterinhaDigitalAppPreview() {
    CarterinhaDigitalTheme{
        CarterinhaDigitalApp(
            modifier = Modifier.fillMaxSize()
        )

   }
}