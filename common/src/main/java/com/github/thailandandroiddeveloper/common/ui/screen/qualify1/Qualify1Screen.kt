package com.github.thailandandroiddeveloper.common.ui.screen.qualify1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@Composable
fun Qualify1Screen() {
    Scaffold(
        topBar = { AppBar() },
        containerColor = MaterialTheme.colorScheme.onPrimary
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(contentPadding)
        ) {
            ContentCard()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        navigationIcon = {
            IconButton(
                onClick = { /*TODO*/ },
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.ic_qualify_1_menu),
                    contentDescription = "menu button",
                )
            }
        },
        actions = {
            IconButton(
                modifier = Modifier.size(40.dp),
                onClick = { /*TODO*/ },
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.ic_qualify_1_profile),
                    contentDescription = "profile button",
                )
            }
        },
        title = {},
    )
}

@Composable
fun ContentCard() {
    ConstraintLayout(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
        val (image, overlay, button) = createRefs()
        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .constrainAs(image) {},
            painter = painterResource(id = R.drawable.img_qualify_1_profile),
            contentDescription = "image jone due",
            contentScale = ContentScale.FillWidth
        )
        Box(
            modifier = Modifier
                .constrainAs(overlay) {
                    start.linkTo(image.start)
                    end.linkTo(image.end)
                    bottom.linkTo(image.bottom)
                },
        ) {
            ContentOverlay()
        }
        Box(modifier = Modifier.constrainAs(button) {
            bottom.linkTo(image.bottom)
            top.linkTo(image.bottom)
        }) {
            ContentButton()
        }
    }
}

@Composable
fun ContentOverlay() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
            .background(
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.75F)
            )

    ) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 40.dp)
        ) {
            Text(
                text = "John Doe",
                style = MaterialTheme.typography.headlineMedium
                    .copy(color = MaterialTheme.colorScheme.onPrimary)
            )
            Row(modifier = Modifier.padding(top = 10.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_1_gender_male),
                    contentDescription = "gender male icon",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Male",
                    style = MaterialTheme.typography.bodyMedium
                        .copy(color = MaterialTheme.colorScheme.onPrimary)
                )
            }
            Text(
                text = "Lorem ipsum dolor sit amet, cd nulla lacinia, quis fringilla lorem imperdiet. Proin in quam vel odio iaculis fringilla.",
                style = MaterialTheme.typography.bodyMedium
                    .copy(color = MaterialTheme.colorScheme.onPrimary),
                modifier = Modifier.padding(top = 10.dp)
            )
        }
    }
}

@Composable
fun ContentButton() {
    Box(
        Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ButtonAction(
                icon = R.drawable.ic_qualify_1_thumb_down,
                contentDescription = "button dislike",
                containerColor = MaterialTheme.colorScheme.errorContainer,
                contentColor = MaterialTheme.colorScheme.onErrorContainer
            )
            ButtonAction(
                icon = R.drawable.ic_qualify_1_thumb_up,
                contentDescription = "button dislike",
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Composable
fun ButtonAction(
    icon: Int,
    contentDescription: String,
    containerColor: Color,
    contentColor: Color
) {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .width(120.dp)
            .height(48.dp),
        colors = ButtonDefaults.textButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
        )
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = contentDescription,
        )
    }
}

@Composable
@Preview
fun ContentOverlayPreview() {
    AppTheme {
        ContentOverlay()
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify1ScreenPreview() = AppTheme {
    Qualify1Screen()
}
// endregion