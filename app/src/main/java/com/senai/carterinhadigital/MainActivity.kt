package com.senai.carterinhadigital

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Column(
        modifier=modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(200.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = null
        )
        Image(
            painter = painterResource(R.drawable.perfil),
            contentDescription = null
        )
    }
}
