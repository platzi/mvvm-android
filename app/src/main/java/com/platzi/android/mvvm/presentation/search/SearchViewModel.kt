package com.platzi.android.mvvm.presentation.search


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.platzi.android.mvvm.app.domain.tracker.use_case.TrackerUseCases
import com.platzi.android.mvvm.core.domain.use_case.FilterOutDigits
import com.platzi.android.mvvm.core.domain.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val trackerUseCases: TrackerUseCases,
    private val filterOutDigits: FilterOutDigits
) : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun executeSearch() {
        viewModelScope.launch {
            trackerUseCases.searchFoodUseCase("egg")
        }
    }

}