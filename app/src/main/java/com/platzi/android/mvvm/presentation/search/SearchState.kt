package com.platzi.android.mvvm.presentation.search

import com.platzi.android.mvvm.presentation.search.model.TrackableFoodUiState

data class SearchState(
    val query: String = "",
    val isHintVisible: Boolean = false,
    val isSearching: Boolean = false,
    val trackableFood: List<TrackableFoodUiState> = emptyList()
)