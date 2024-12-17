package com.platzi.android.mvvm.app.presentation.onboarding.nutrient_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.platzi.android.mvvm.app.presentation.onboarding.components.ActionButton
import com.platzi.android.mvvm.app.presentation.onboarding.components.UnitTextField
import com.platzi.android.mvvm.app.ui.theme.LocalSpacing
import com.platzi.android.mvvm.app.R
import com.platzi.android.mvvm.core.domain.util.UiEvent

@Composable
fun NutrientGoalScreen(
    snackbarState: SnackbarHostState,
    onNextClick: () -> Unit,
    nutrientGoalViewModel: NutrientGoalViewModel = viewModel()
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        nutrientGoalViewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Success -> onNextClick()
                is UiEvent.ShowSnackbar -> {
                    snackbarState.showSnackbar(
                        message = event.message.asString(context)
                    )
                }

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
                text = stringResource(id = R.string.what_are_your_nutrient_goals),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = nutrientGoalViewModel.state.carbsRatio,
                onValueChange = {
                    nutrientGoalViewModel.onEvent(NutrientGoalEvent.OnCarbRatioEnter(it))
                },
                unit = stringResource(id = R.string.percent_carbs)
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = nutrientGoalViewModel.state.proteinRatio,
                onValueChange = {
                    nutrientGoalViewModel.onEvent(NutrientGoalEvent.OnProteinRatioEnter(it))
                },
                unit = stringResource(id = R.string.percent_proteins)
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = nutrientGoalViewModel.state.fatRatio,
                onValueChange = {
                    nutrientGoalViewModel.onEvent(NutrientGoalEvent.OnFatRatioEnter(it))
                },
                unit = stringResource(id = R.string.percent_fats)
            )
        }
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = {
                nutrientGoalViewModel.onEvent(NutrientGoalEvent.OnNextClick)
            },
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}