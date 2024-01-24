package com.github.thailandandroiddeveloper.common.ui.screen.qualify2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@Composable
fun Qualify2Screen() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (button, title, body, image, stickyButton, indicator) = createRefs()

        TextButton(
            onClick = { /*TODO*/ },
            shape = RectangleShape,
            contentPadding = PaddingValues(top = 8.dp, end = 2.dp),
            modifier = Modifier.constrainAs(button) { end.linkTo(parent.end, 8.dp) }
        ) {
            Text(
                text = "Skip",
                style = MaterialTheme.typography.labelLarge.copy(color = MaterialTheme.colorScheme.primary),
                textAlign = TextAlign.Center,
                letterSpacing = .1.sp,
            )
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(title) { top.linkTo(button.bottom, 16.dp) },
            text = "Lorem ipsum dolor sit amet",
            style = MaterialTheme.typography.headlineSmall
                .copy(
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                    letterSpacing = .5.sp,
                ),
        )
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec egestas dictum lacinia. Integer arcu neque, porttitor ac metus quis, iaculis molestie magna. Vivamus molestie justo sed nulla lacinia, quis fringilla lorem imperdiet. Proin in quam vel odio iaculis fringilla",
            style = MaterialTheme.typography.bodyMedium
                .copy(
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                    letterSpacing = .5.sp,
                ),
            modifier = Modifier
                .constrainAs(body) { top.linkTo(title.bottom, 16.dp) }
                .padding(horizontal = 32.dp)
        )
        Column(modifier = Modifier
            .constrainAs(image) {
                top.linkTo(body.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            .padding(top = 36.dp)
        ) {
            Image(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .padding(horizontal = 32.dp),
                painter = painterResource(id = R.drawable.img_qualify_2_onboard),
                contentDescription = "onboard",
            )
        }
        Column(modifier = Modifier.constrainAs(indicator) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(stickyButton.top)
        }) {
            DotIndicator()
        }
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .height(102.dp)
                .padding(horizontal = 80.dp)
                .fillMaxWidth()
                .constrainAs(stickyButton) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .width(251.dp)
                    .height(40.dp),
                colors = ButtonDefaults.textButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.primary
                ),
            ) {
                Text(
                    text = "Next",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.labelLarge.copy(letterSpacing = .5.sp),
                )
            }
        }
    }
}

@Composable
fun DotIndicator() {
    Row(Modifier.padding(bottom = 48.dp, top = 32.dp)) {
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