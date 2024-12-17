package com.platzi.android.mvvm.app.presentation.onboarding.activity_level_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.platzi.android.mvvm.app.presentation.onboarding.components.ActionButton
import com.platzi.android.mvvm.app.presentation.onboarding.components.SelectableButton
import com.platzi.android.mvvm.app.ui.theme.LocalSpacing
import com.platzi.android.mvvm.app.R
import com.platzi.android.mvvm.core.domain.model.ActivityLevel
import com.platzi.android.mvvm.core.domain.util.UiEvent

@Composable
fun ActivityLevelScreen(
    onNextClick: () -> Unit,
    activityLevelViewModel: ActivityLevelViewModel = viewModel()
) {
    val spacing = LocalSpacing.current
    LaunchedEffect(key1 = true) {
        activityLevelViewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Success -> onNextClick()
                else -> Unit
            }
        }
    }

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
                text = stringResource(id = R.string.whats_your_activity_level),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Row {
                SelectableButton(
                    text = stringResource(id = R.string.low),
                    isSelected = activityLevelViewModel.selectedActivityLevel is ActivityLevel.Low,
                    color = MaterialTheme.colorScheme.primary,
                    selectedTextColor = Color.White,
                    onClick = {
                        activityLevelViewModel.onActivityLevelSelect(ActivityLevel.Low)
                    },
                    textStyle = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = R.string.medium),
                    isSelected = activityLevelViewModel.selectedActivityLevel is ActivityLevel.Medium,
                    color = MaterialTheme.colorScheme.primary,
                    selectedTextColor = Color.White,
                    onClick = {
                        activityLevelViewModel.onActivityLevelSelect(ActivityLevel.Medium)
                    },
                    textStyle = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = R.string.high),
                    isSelected = activityLevelViewModel.selectedActivityLevel is ActivityLevel.High,
                    color = MaterialTheme.colorScheme.primary,
                    selectedTextColor = Color.White,
                    onClick = {
                        activityLevelViewModel.onActivityLevelSelect(ActivityLevel.High)
                    },
                    textStyle = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = activityLevelViewModel::onNextClick,
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}