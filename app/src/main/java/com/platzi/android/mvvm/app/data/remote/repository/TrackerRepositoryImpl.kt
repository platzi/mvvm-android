package com.platzi.android.mvvm.app.data.remote.repository

import com.platzi.android.mvvm.app.data.remote.api.OpenFoodApi
import com.platzi.android.mvvm.app.data.remote.mapper.toTrackableFood
import com.platzi.android.mvvm.app.domain.tracker.model.TrackableFood
import com.platzi.android.mvvm.app.domain.tracker.repository.TrackerRepository

class TrackerRepositoryImpl(
    private val api: OpenFoodApi
) : TrackerRepository {
    override suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>> {
        return try {
            val searchDto = api.searchFood(
                query = query,
                page = page,
                pageSize = pageSize
            )
            Result.success(
                searchDto.products
                    .filter {
                        val calculatedCalories =
                            it.nutriments.carbohydrates100g * 4f +
                                    it.nutriments.proteins100g * 4f +
                                    it.nutriments.fat100g * 9f
                        val lowerBound = calculatedCalories * 0.99f
                        val upperBound = calculatedCalories * 1.01f
                        it.nutriments.energyKcal100g in (lowerBound..upperBound)
                    }
                    .mapNotNull { it.toTrackableFood() }
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}