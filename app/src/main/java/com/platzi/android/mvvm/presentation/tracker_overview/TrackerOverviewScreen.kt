package com.platzi.android.mvvm.presentation.tracker_overview

import android.content.res.Configuration
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.platzi.android.mvvm.app.ui.theme.LocalSpacing
import com.platzi.android.mvvm.app.ui.theme.PlatziCaloriesTheme
import com.platzi.android.mvvm.presentation.tracker_overview.components.NutrientsHeader

@Composable
fun TrackerOverviewScreen(
    trackerOverviewViewModel: TrackerOverviewViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = spacing.spaceMedium)
    ) {
        item {
            NutrientsHeader()
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
        }
    }
}

@Composable
fun TrackOverviewScreenTest(){
    val spacing = LocalSpacing.current
    val context = LocalContext.current

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = spacing.spaceMedium)
    ) {
        item {
            NutrientsHeader()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TrackOverviewScreenPreview() {
    PlatziCaloriesTheme {
        TrackOverviewScreenTest()
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun TrackOverviewScreenPreviewDark() {
    PlatziCaloriesTheme {
        TrackOverviewScreenTest()
    }
}