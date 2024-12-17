package com.platzi.android.mvvm.presentation.search

sealed class SearchEvent {
    data class OnQueryChanged(val query: String) : SearchEvent()
    data object OnSearch : SearchEvent()
    data class OnSearchFocusChange(val isFocused: Boolean) : SearchEvent()
}