package com.main.data.local.FridgeInventory

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface FridgeInventoryDao {

    @Insert(entity = FridgeInventoryEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertFridgeInventory(fridgeInventory: FridgeInventoryEntity)

    @Query("SELECT * FROM fridgeInventory_db")
    fun getFridgeInventoryById() : Flow<List<FridgeInventoryEntity>>?

    // suspend?
}