package com.platzi.android.mvvm.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.platzi.android.mvvm.app.R
import com.platzi.android.mvvm.app.ui.theme.LocalSpacing
import com.platzi.android.mvvm.presentation.search.components.SearchTextField

@Composable
fun SearchScreen(
    snackbarHostState: SnackbarHostState,
    mealName: String,
    dayOfMonth: Int,
    month: Int,
    year: Int,
    onNavigateUp: () -> Unit,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceMedium)
    ) {
        Spacer(modifier = Modifier.height(spacing.spaceLarge))
        Text(
            text = stringResource(id = R.string.add_meal, mealName),
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        SearchTextField(
            text = "",
            onValueChange = {},
            shouldShowHint = true,
            onSearch = {
                searchViewModel.executeSearch()
                keyboardController?.hide()
            },
            onFocusChanged = {}
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
    }

}