package com.platzi.android.mvvm.presentation.tracker_overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.platzi.android.mvvm.app.domain.tracker.use_case.TrackerUseCases
import com.platzi.android.mvvm.core.domain.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//TODO -> Se usara este viewmodel para probar el search, luego en la prox clase se borrara

@HiltViewModel
class TrackerOverviewViewModel @Inject constructor(
    preferences: Preferences,
    private val trackerUseCases: TrackerUseCases
) : ViewModel() {

    init {
        preferences.saveShouldShowOnboarding(false)
        executeSearch()
    }

    //TODO -> Funcion para probar search, se borrara en la proxima clase
    private fun executeSearch(){
        viewModelScope.launch {
            trackerUseCases.searchFoodUseCase("egg")
        }
    }
}