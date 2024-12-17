package com.platzi.android.mvvm.app.presentation.onboarding.age_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.platzi.android.mvvm.app.R
import com.platzi.android.mvvm.app.presentation.onboarding.components.ActionButton
import com.platzi.android.mvvm.app.presentation.onboarding.components.UnitTextField
import com.platzi.android.mvvm.app.ui.theme.LocalSpacing
import com.platzi.android.mvvm.app.ui.theme.PlatziCaloriesTheme

@SuppressLint("UnrememberedMutableState")
@Composable
fun AgeScreen(
    onNextClick: () -> Unit,
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current

    var age by mutableStateOf("20")


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(spacing.spaceLarge)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.whats_your_age),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = age,
                onValueChange = {},
                unit = stringResource(id = R.string.years)
            )
        }
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = { onNextClick()},
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AgeScreenPreview() {
    PlatziCaloriesTheme {
        AgeScreen {}
    }
}