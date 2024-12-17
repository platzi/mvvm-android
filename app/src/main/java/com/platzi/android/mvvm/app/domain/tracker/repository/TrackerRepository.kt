package com.platzi.android.mvvm.app.domain.tracker.repository

import com.platzi.android.mvvm.app.domain.tracker.model.TrackableFood
import com.platzi.android.mvvm.app.domain.tracker.model.TrackedFood
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface TrackerRepository {

    suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>>

    suspend fun insertTrackedFood(food: TrackedFood)
    fun getFoodsForDate(localDate: LocalDate): Flow<List<TrackedFood>>
}