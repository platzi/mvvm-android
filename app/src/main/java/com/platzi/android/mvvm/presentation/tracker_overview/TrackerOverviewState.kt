package com.platzi.android.mvvm.presentation.tracker_overview

import com.platzi.android.mvvm.app.domain.tracker.model.TrackedFood
import com.platzi.android.mvvm.presentation.tracker_overview.model.Meal
import com.platzi.android.mvvm.presentation.tracker_overview.model.defaultMeals
import java.time.LocalDate

data class TrackerOverviewState(
    val totalCarbs: Int = 0,
    val totalProtein: Int = 0,
    val totalFat: Int = 0,
    val totalCalories: Int = 0,
    val carbsGoal: Int = 0,
    val proteinGoal: Int = 0,
    val fatGoal: Int = 0,
    val caloriesGoal: Int = 0,
    val date: LocalDate = LocalDate.now(),
    val trackedFoods: List<TrackedFood> = emptyList(),
    val meals: List<Meal> = defaultMeals
)
