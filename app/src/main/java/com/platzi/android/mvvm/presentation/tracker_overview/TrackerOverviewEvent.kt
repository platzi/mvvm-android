package com.platzi.android.mvvm.presentation.tracker_overview

import com.platzi.android.mvvm.app.domain.tracker.model.TrackedFood
import com.platzi.android.mvvm.presentation.tracker_overview.model.Meal

sealed class TrackerOverviewEvent {
    data object OnNextDayClick: TrackerOverviewEvent()
    data object OnPreviousDayClick: TrackerOverviewEvent()
    data class OnToggleMealClick(val meal: Meal) : TrackerOverviewEvent()
    data class OnDeleteTrackedFoodClick(val trackedFood: TrackedFood): TrackerOverviewEvent()
}