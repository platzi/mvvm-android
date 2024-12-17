package com.platzi.android.mvvm.presentation.tracker_overview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.platzi.android.mvvm.app.ui.theme.LocalSpacing
import com.platzi.android.mvvm.app.ui.theme.PlatziCaloriesTheme
import com.platzi.android.mvvm.presentation.tracker_overview.components.DaySelector
import com.platzi.android.mvvm.presentation.tracker_overview.components.ExpandableMeal
import com.platzi.android.mvvm.presentation.tracker_overview.components.NutrientsHeader
import com.platzi.android.mvvm.presentation.tracker_overview.model.defaultMeals
import java.time.LocalDate

@Composable
fun TrackerOverviewScreen(
    onNavigateToSearch: () -> Unit,
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
            DaySelector(
                date = LocalDate.now(),
                onPreviousDayClick = {

                },
                onNextDayClick = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = spacing.spaceMedium)
            )
        }
        items(defaultMeals){ meal ->
            ExpandableMeal(
                meal = meal,
                onToggleClick = {
                    onNavigateToSearch()//TODO: Test Navigate to Search
                },
                content = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = spacing.spaceSmall)
                    ) {

                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
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
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            DaySelector(
                date = LocalDate.now(),
                onPreviousDayClick = {

                },
                onNextDayClick = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = spacing.spaceMedium)
            )
        }
        items(defaultMeals){ meal ->
            ExpandableMeal(
                meal = meal,
                onToggleClick = {

                },
                content = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = spacing.spaceSmall)
                    ) {

                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
private fun TrackOverviewScreenPreview() {
    PlatziCaloriesTheme {
        TrackOverviewScreenTest()
    }
}