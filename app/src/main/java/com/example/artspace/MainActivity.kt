package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}


@Composable
fun ArtSpaceApp() {
    var currentPage by remember { mutableStateOf(1) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.tertiaryContainer),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            Text(
                text = "Pokemon App",
                fontSize = 20.sp,
                color = Color(0xFF222224),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFFEE1515))
                    .padding(20.dp)
            )
            when (currentPage) {
                1 -> {
                    PokemonTextAndImage(
                        textLabelResourceId = R.string.charmander_label,
                        drawableResourceId = R.drawable.charmander_image,
                        textDescriptionResourceId = R.string.charmander_desc,
                    )
                }
                2 -> {
                    PokemonTextAndImage(
                        textLabelResourceId = R.string.squirtle_label,
                        drawableResourceId = R.drawable.squirtle_image,
                        textDescriptionResourceId = R.string.squirtle_desc,
                    )
                }
                3 -> {
                    PokemonTextAndImage(
                        textLabelResourceId = R.string.bulbasaur_label,
                        drawableResourceId = R.drawable.bulbasaur_image,
                        textDescriptionResourceId = R.string.bulbasaur_desc,
                    )
                }
                4 -> {
                    PokemonTextAndImage(
                        textLabelResourceId = R.string.pikachu_label,
                        drawableResourceId = R.drawable.pikachu_image,
                        textDescriptionResourceId = R.string.pikachu_desc,
                    )
                }
                5 -> {
                    PokemonTextAndImage(
                        textLabelResourceId = R.string.alolan_ninetales_label,
                        drawableResourceId = R.drawable.alolan_ninetales_image,
                        textDescriptionResourceId = R.string.alolan_ninetales_desc,
                    )
                }
                6 -> {
                    PokemonTextAndImage(
                        textLabelResourceId = R.string.gengar_label,
                        drawableResourceId = R.drawable.gengar_image,
                        textDescriptionResourceId = R.string.gengar_desc,
                    )
                }
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = Color(0xFF222224))
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1f)
            ) {
                PageSwitchButton(
                    textLabelResourceId = R.string.previous,
                    onClick = { currentPage = if (currentPage - 1 < 1) 6 else currentPage - 1 }
                )
                PageSwitchButton(
                    textLabelResourceId = R.string.next,
                    onClick = { currentPage = if (currentPage + 1 > 6) 1 else currentPage + 1 }
                )
            }
        }
    }
}

@Composable
fun PokemonTextAndImage(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    textDescriptionResourceId: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Spacer(modifier = modifier.height(70.dp))
        Image(
            painter = painterResource(drawableResourceId),
            contentDescription = null,
            modifier = modifier
                .border(
                    border = BorderStroke(1.dp, Color(0xFF222224)),
                    shape = RoundedCornerShape(5.dp)
                )
        )
        Spacer(modifier = modifier.height(20.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = modifier
                .fillMaxWidth(0.585f)
                .fillMaxHeight(0.75f)
        ) {
            Text(
                text = stringResource(textLabelResourceId),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = modifier.height(10.dp))
            Text(
                text = stringResource(textDescriptionResourceId),
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Composable
fun PageSwitchButton(
    textLabelResourceId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        border = BorderStroke(1.dp, Color(0xFF222224)),
        shape = RoundedCornerShape(40.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF0F0F0)),
        modifier = modifier.size(width = 140.dp, height = 40.dp)
    ) {
        Text(
            text = stringResource(textLabelResourceId),
            fontSize = 16.sp,
            color = Color(0xFF222224)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}
