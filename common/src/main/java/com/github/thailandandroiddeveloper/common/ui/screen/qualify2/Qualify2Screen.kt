package com.github.thailandandroiddeveloper.common.ui.screen.qualify2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@Composable
fun Qualify2Screen() {
    Scaffold(
        topBar = { },
        containerColor = MaterialTheme.colorScheme.onPrimary
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(contentPadding),
        ) {
            SkipButton()
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxHeight()
        ) {
            Box(modifier = Modifier.padding(16.dp)) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(38.dp),
                    text = "Lorem ipsum dolor sit amet",
                    style = MaterialTheme.typography.headlineSmall
                        .copy(
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Center
                        )
                )
            }
            Box(modifier = Modifier.padding(horizontal = 32.dp)) {
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec egestas dictum lacinia. Integer arcu\n neque, porttitor ac metus quis, iaculis molestie magna. Vivamus molestie justo sed nulla lacinia, quis fringilla lorem imperdiet. Proin in quam vel odio  iaculis fringilla",
                    style = MaterialTheme.typography.bodyMedium
                        .copy(
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Center
                        )
                )
            }
            Box(modifier = Modifier.padding(31.dp)) {
                Image(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp)),
                    painter = painterResource(id = R.drawable.img_qualify_2_onboard),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth
                )
            }
            Box(modifier = Modifier.padding(bottom = 48.dp)) {
                DotIndicator()
            }
            StickyButton()
        }
    }
}

@Composable
private fun StickyButton() {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .height(102.dp)
            .padding(horizontal = 80.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            colors = ButtonDefaults.textButtonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.primary
            )

        ) {
            Text(
                text = "Next",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}


@Composable
fun SkipButton() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End
    ) {
        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(end = 6.dp, top = 6.dp),
            contentPadding = PaddingValues(
                start = 12.dp,
                top = 10.dp,
                end = 12.dp,
                bottom = 10.dp,
            )
        ) {
            Text(text = "Skip", style = MaterialTheme.typography.labelLarge)
        }
    }
}

@Composable
fun DotIndicator() {
    Row {
        DotIndicatorInActive()
        Spacer(modifier = Modifier.padding(end = 8.dp))
        DotIndicatorInActive()
        Spacer(modifier = Modifier.padding(end = 8.dp))
        DotIndicatorInActive()
        Spacer(modifier = Modifier.padding(end = 8.dp))
        DotIndicatorActive()
        Spacer(modifier = Modifier.padding(end = 8.dp))
        DotIndicatorInActive()

    }
}

@Composable
fun DotIndicatorActive() {
    Spacer(
        modifier = Modifier
            .width(32.dp)
            .height(16.dp)
            .clip(CircleShape)
            .background(color = MaterialTheme.colorScheme.primary),
    )
}

@Composable
fun DotIndicatorInActive() {
    Spacer(
        modifier = Modifier
            .size(16.dp)
            .clip(CircleShape)
            .background(color = MaterialTheme.colorScheme.primaryContainer),
    )
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify2ScreenPreview() = AppTheme {
    Qualify2Screen()
}
// endregion