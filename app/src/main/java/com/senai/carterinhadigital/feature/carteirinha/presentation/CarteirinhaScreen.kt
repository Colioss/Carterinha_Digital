package com.senai.carterinhadigital.feature.carteirinha.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rafaelcosta.carteirinhadigital_4devm_t1.feature.carteirinha.presentation.component.QrCode
import com.senai.carterinhadigital.R
import com.senai.carterinhadigital.core.designsystem.theme.CarteirinhaDigitalTheme

@Composable
fun CarteirinhaScreen(modifier: Modifier = Modifier,
                      onBackClick: () -> Unit = {}){
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.wallpaper),
            contentDescription = "Fundo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(17.dp),
            modifier = modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.senailogo),
                contentDescription = null




            )
            Image(
                painter = painterResource(id = R.drawable.perfilgatinho),
                contentDescription = stringResource(id = R.string.app_name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(16.dp))

            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val offset = Offset(5.0f, 10.0f)

                Text(
                    text = "Nome:",
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = Color.White,
                        shadow = Shadow(
                            color = Color.Red,
                            offset = offset,
                            blurRadius = 3f
                        )
                    )
                )

                Text(
                    text = "Gustavo Coelho",
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = Color.White,
                        shadow = Shadow(
                            color = Color.Red,
                            offset = offset,
                            blurRadius = 3f
                        )
                    )
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val offset = Offset(5.0f, 10.0f)


                Text(
                    text = "Curso:",
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = Color.White,
                        shadow = Shadow(
                            color = Color.Blue,
                            offset = offset,
                            blurRadius = 3f
                        )
                    )
                )

                Text(
                    text = "Desenvolvimento de sistemas",
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = Color.White,
                        shadow = Shadow(
                            color = Color.Blue,
                            offset = offset,
                            blurRadius = 3f
                        )
                    )
                )
            }
            QrCode(
                "90000000001756464093",
                modifier = Modifier
                    .border(
                        width = 4.dp,
                        Color.DarkGray
                    )
            )
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun CarteirinhaScreenPreview(){
    CarteirinhaDigitalTheme {
        CarteirinhaScreen()
    }
}



