package com.platzi.android.mvvm.app.domain.tracker.use_case

import com.platzi.android.mvvm.app.domain.tracker.model.TrackedFood
import com.platzi.android.mvvm.app.domain.tracker.repository.TrackerRepository

class DeleteTrackedFoodUseCase(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(trackedFood: TrackedFood) {
        repository.deleteTrackedFood(trackedFood)
    }
}