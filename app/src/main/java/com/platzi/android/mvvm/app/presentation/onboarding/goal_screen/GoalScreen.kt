package com.platzi.android.mvvm.app.presentation.onboarding.goal_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.platzi.android.mvvm.app.presentation.onboarding.components.ActionButton
import com.platzi.android.mvvm.app.presentation.onboarding.components.SelectableButton
import com.platzi.android.mvvm.app.ui.theme.LocalSpacing
import com.platzi.android.mvvm.app.R

@Composable
fun GoalScreen(
    onNextClick: () -> Unit,
) {
    val spacing = LocalSpacing.current

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
                text = stringResource(id = R.string.lose_keep_or_gain_weight),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Row {
                SelectableButton(
                    text = stringResource(id = R.string.lose),
                    isSelected = false,
                    color = MaterialTheme.colorScheme.primary,
                    selectedTextColor = Color.White,
                    onClick = {

                    },
                    textStyle = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = R.string.keep),
                    isSelected = true,
                    color = MaterialTheme.colorScheme.primary,
                    selectedTextColor = Color.White,
                    onClick = {

                    },
                    textStyle = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = R.string.gain),
                    isSelected = false,
                    color = MaterialTheme.colorScheme.primary,
                    selectedTextColor = Color.White,
                    onClick = {

                    },
                    textStyle = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = { onNextClick() },
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}