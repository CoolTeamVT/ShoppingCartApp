package com.main.domain.repository

import com.main.data.local.FridgeInventory.FridgeInventoryEntity
import kotlinx.coroutines.flow.Flow

interface FridgeInventoryRepository {
    suspend fun getFridgeInventories(): Flow<List<FridgeInventoryEntity>>?
    suspend fun addFridgeInventory(fridgeInventory: FridgeInventoryEntity)
    //TODO
    //suspend fun getFridgeInventoryById(id: Int): FridgeInventoryEntity?
    //suspend fun deleteFridgeInventory(id: Int)
}