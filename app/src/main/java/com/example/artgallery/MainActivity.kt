package com.example.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtGalleryTheme {
                PlayerPanel()
            }
        }
    }
}

@Composable
fun PlayerPanel() {
    var result by remember { mutableIntStateOf(1) }

    val (imageResult, name) = when (result) {
        1 -> listOf(R.drawable.stegen1, R.string.stegen)
        2 -> listOf(R.drawable.szczesny2, R.string.szczesny)
        3 -> listOf(R.drawable.araujo5, R.string.araujo)
        4 -> listOf(R.drawable.balde7, R.string.balde)
        5 -> listOf(R.drawable.casado8, R.string.casado)
        6 -> listOf(R.drawable.martinez6, R.string.martinez)
        7 -> listOf(R.drawable.kounde4, R.string.kounde)
        8 -> listOf(R.drawable.cubarsi2, R.string.cubarsi)
        9 -> listOf(R.drawable.gavi9, R.string.gavi)
        10 -> listOf(R.drawable.pedri10, R.string.pedri)
        11 -> listOf(R.drawable.olmo11, R.string.olmo)
        12 -> listOf(R.drawable.raphinha12, R.string.raphinha)
        13 -> listOf(R.drawable.lamine13, R.string.lamine)
        14 -> listOf(R.drawable.lewandowski14, R.string.lewandowski)
        else -> listOf(R.drawable.stegen1, R.string.stegen)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            stringResource(R.string.titulo),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(60.dp)
                .fillMaxWidth()
        )
        Image(
            painter = painterResource(imageResult),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(320.dp)
                .aspectRatio(9f / 9f)
                .align(Alignment.CenterHorizontally)
                .clip(CircleShape)
                .shadow(
                    elevation = 15.dp, // Elevación de la sombra
                    shape = RectangleShape, // Forma de la sombra (opcional)
                    clip = false // Si la sombra debe recortarse según la forma
                )
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            stringResource(name),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Button(
                onClick = {
                    result = previousImage(result)
                }, modifier = Modifier
                    .padding(12.dp)
            ) {
                Text("Previous")
            }
            Button(
                onClick = {
                    result = nextImage(result)
                }, modifier = Modifier
                    .padding(12.dp)
            ) {
                Text("Next")
            }
        }

    }
}
@VisibleForTesting
internal fun nextImage(result : Int) : Int {
    var resultImage: Int = result
    if (resultImage == 14) {
        resultImage = 1
    }else {
        resultImage++
    }
    return resultImage
}
@VisibleForTesting
internal fun previousImage(result : Int) : Int {
    var resultImage: Int = result
    if (resultImage == 1) {
        resultImage = 14
    }else {
        resultImage--
    }
    return resultImage
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtGalleryTheme {
        PlayerPanel()
    }
}