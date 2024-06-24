package com.main.data.repository

import com.main.data.local.FridgeInventory.FridgeInventoryDao
import com.main.data.local.FridgeInventory.FridgeInventoryEntity
import com.main.domain.repository.FridgeInventoryRepository
import kotlinx.coroutines.flow.Flow

class FridgeInventoryRepositoryImpl(private val fridgeInventoryDao: FridgeInventoryDao) : FridgeInventoryRepository{
    override suspend fun getFridgeInventories(): Flow<List<FridgeInventoryEntity>> {
        return fridgeInventoryDao.getFridgeInventories()
    }

    override suspend fun addFridgeInventory(fridgeInventory: FridgeInventoryEntity) {
        fridgeInventoryDao.insertFridgeInventory(fridgeInventory)
    }
}