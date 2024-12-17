package com.platzi.android.mvvm.presentation.search

import com.platzi.android.mvvm.app.domain.tracker.model.TrackableFood

sealed class SearchEvent {
    data class OnQueryChanged(val query: String) : SearchEvent()
    data object OnSearch : SearchEvent()
    data class OnToggleTrackableFood(val food: TrackableFood) : SearchEvent()
    data class OnSearchFocusChange(val isFocused: Boolean) : SearchEvent()
}