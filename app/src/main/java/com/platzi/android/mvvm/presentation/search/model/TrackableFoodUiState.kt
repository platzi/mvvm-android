package com.platzi.android.mvvm.presentation.search.model

import com.platzi.android.mvvm.app.domain.tracker.model.TrackableFood

data class TrackableFoodUiState(
    val food: TrackableFood,
    val isExpanded: Boolean = false,
    val amount: String = ""
)
