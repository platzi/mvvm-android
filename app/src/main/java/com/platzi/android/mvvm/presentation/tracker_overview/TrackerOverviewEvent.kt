package com.platzi.android.mvvm.presentation.tracker_overview

import com.platzi.android.mvvm.presentation.tracker_overview.model.Meal

sealed class TrackerOverviewEvent {
    data class OnToggleMealClick(val meal: Meal) : TrackerOverviewEvent()
}