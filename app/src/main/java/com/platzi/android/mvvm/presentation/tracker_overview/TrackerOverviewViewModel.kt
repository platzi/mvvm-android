package com.platzi.android.mvvm.presentation.tracker_overview

import androidx.lifecycle.ViewModel
import com.platzi.android.mvvm.core.domain.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TrackerOverviewViewModel @Inject constructor(
    preferences: Preferences
) : ViewModel() {

    init {
        preferences.saveShouldShowOnboarding(false)
    }
}