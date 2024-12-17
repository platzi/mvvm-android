package com.platzi.android.mvvm.app.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.platzi.android.mvvm.app.data.local.entity.TrackedFoodEntity
import com.platzi.android.mvvm.app.data.local.dao.TrackerDao

@Database(
    entities = [TrackedFoodEntity::class],
    version = 1
)
abstract class TrackerDatabase : RoomDatabase() {
    abstract val dao: TrackerDao
}