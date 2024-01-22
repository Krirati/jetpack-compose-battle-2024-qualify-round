package com.github.thailandandroiddeveloper.common.ui.screen.qualify3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@Composable
fun Qualify3Screen() {
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
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .padding(top = 16.dp)
            ) {
                CardItem(R.drawable.img_qualify_3_photo_1, true)
                CardItem(R.drawable.img_qualify_3_photo_2, false)
                CardItem(R.drawable.img_qualify_3_photo_3, false)
            }

            Tags()

            CardContent(
                title = "Lorem Ipsum",
                body = "Duis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo consectetur. Sed congue blandit nibh."
            )
            CardContent(
                title = "Lorem Ipsum",
                body = "Morbi sed sagittis justo, at pulvinar ipsum. Praesent massa metus, interdum at suscipit a, interdum vel orci. Pellentesque in sapien. Integer faucibus mauris ac luctus aliquam accumsan."
            )
            CardContent(
                title = "Lorem Ipsum",
                body = "Duis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo."
            )
            CardContent(
                title = "Lorem Ipsum",
                body = "Ut hendrerit neque nec accumsan hendrerit. Fusce lobortis rhoncus erat, a blandit nibh molestie vel. Cras commodo ligula ex, vitae venenatis lacus facilisis eget."
            )
        }
    }
}

@Composable
fun CardItem(image: Int, withBorder: Boolean) {
    Box(
        modifier = Modifier
            .padding(start = 16.dp)
            .size(160.dp, 320.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Image(
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = if (withBorder) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp)),
            painter = painterResource(id = image),
            contentDescription = "image jone due",
            contentScale = ContentScale.FillWidth
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun Tags() {
    val lists = listOf("Tag 1", "Tag 2", "Tag 3", "Tag 4")
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        lists.forEach { it ->
            FilterChip(
                modifier = Modifier
                    .height(32.dp),
                selected = it.contains("1"),
                onClick = { },
                label = { Text(it, style = MaterialTheme.typography.labelLarge) },
                colors = FilterChipDefaults.filterChipColors(
                    labelColor = MaterialTheme.colorScheme.outline,
                    selectedLabelColor = MaterialTheme.colorScheme.primary,
                    selectedContainerColor = Color.Transparent
                ),
                border = FilterChipDefaults.filterChipBorder(
                    selectedBorderColor = MaterialTheme.colorScheme.primary,
                    selectedBorderWidth = 1.dp,
                    borderColor = MaterialTheme.colorScheme.outline,
                )
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(
                "John Doe",
                style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onPrimaryContainer)
            )
        },
        navigationIcon = {
            IconButton(
                modifier = Modifier.size(48.dp),
                onClick = { /* do something */ }) {
                Icon(
                    painterResource(id = R.drawable.ic_qualify_3_back),
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        },
        actions = {
            IconButton(
                modifier = Modifier.size(48.dp),
                onClick = { /* do something */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_3_copy),
                    contentDescription = "copy button",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            IconButton(
                modifier = Modifier.size(48.dp),
                onClick = { /* do something */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_3_calendar),
                    contentDescription = "calendar button",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            IconButton(
                modifier = Modifier.size(48.dp),
                onClick = { /* do something */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_3_menu),
                    contentDescription = "menu button",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    )
}

@Composable
fun CardContent(title: String, body: String) {
    Box(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .height(96.dp)
                .background(color = MaterialTheme.colorScheme.surface)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_qualify_3_sender),
                contentDescription = "",
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
            Column(modifier = Modifier.padding(start = 8.dp)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = body,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify3ScreenPreview() = AppTheme {
    Qualify3Screen()
}
// endregion