package com.platzi.android.mvvm.app.domain.tracker.repository

import com.platzi.android.mvvm.app.domain.tracker.model.TrackableFood

interface TrackerRepository {

    suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>>
}