package com.platzi.android.mvvm.app.domain.tracker.use_case

data class TrackerUseCases(
    val searchFoodUseCase: SearchFoodUseCase,
    val trackFoodUseCase: TrackFoodUseCase,
    val getFoodsForDateUseCase: GetFoodsForDateUseCase,
    val deleteTrackedFoodUseCase: DeleteTrackedFoodUseCase,
    val calculateMealNutrientsUseCase: CalculateMealNutrientsUseCase
)