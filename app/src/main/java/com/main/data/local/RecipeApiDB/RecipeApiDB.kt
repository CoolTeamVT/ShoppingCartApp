package com.main.data.local.RecipeApiDB

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [RecipeApiEntity::class],
    version =  1
)
abstract class RecipeApiDB : RoomDatabase() {
    abstract val dao: RecipeApiDao
}