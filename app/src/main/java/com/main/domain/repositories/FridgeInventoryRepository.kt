package com.main.domain.repositories

import com.main.domain.models.FridgeInventoryModel
import kotlinx.coroutines.flow.Flow

interface FridgeInventoryRepository {
    suspend fun getFridgeInventories(): Flow<List<FridgeInventoryModel>>
    suspend fun addFridgeInventory(fridgeInventoryModel: FridgeInventoryModel)
    //TODO
    //suspend fun getFridgeInventoryById(id: Int): FridgeInventoryEntity?
    //suspend fun deleteFridgeInventory(id: Int)
}