package com.platzi.android.mvvm.app.presentation.onboarding.nutrient_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.platzi.android.mvvm.app.domain.use_case.ValidateNutrients
import com.platzi.android.mvvm.core.domain.use_case.FilterOutDigits
import com.platzi.android.mvvm.core.domain.util.UiEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class NutrientGoalViewModel : ViewModel() {
    private val filterOutDigits = FilterOutDigits()
    private val validateNutrients = ValidateNutrients()

    var state by mutableStateOf(NutrientGoalState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: NutrientGoalEvent) {
        when (event) {
            is NutrientGoalEvent.OnCarbRatioEnter -> {
                state = state.copy(
                    carbsRatio = filterOutDigits(event.ratio)
                )
            }

            is NutrientGoalEvent.OnProteinRatioEnter -> {
                state = state.copy(
                    proteinRatio = filterOutDigits(event.ratio)
                )
            }

            is NutrientGoalEvent.OnFatRatioEnter -> {
                state = state.copy(
                    fatRatio = filterOutDigits(event.ratio)
                )
            }

            is NutrientGoalEvent.OnNextClick -> {
                val result = validateNutrients(
                    carbsRatioText = state.carbsRatio,
                    proteinRatioText = state.proteinRatio,
                    fatRatioText = state.fatRatio
                )
                when (result) {
                    is ValidateNutrients.Result.Success -> {
                        viewModelScope.launch {
                            _uiEvent.send(UiEvent.Success)
                        }
                    }

                    is ValidateNutrients.Result.Error -> {
                        viewModelScope.launch {
                            _uiEvent.send(UiEvent.ShowSnackbar(result.message))
                        }
                    }
                }
            }
        }
    }
}