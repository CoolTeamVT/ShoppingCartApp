package com.main.data.repositories

import com.main.data.local.FridgeInventoryDB.FridgeInventoryDao
import com.main.data.local.utils.fromModelToEntity
import com.main.data.local.utils.toFridgeInventoryModel
import com.main.domain.models.FridgeInventoryModel
import com.main.domain.repositories.FridgeInventoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class FridgeInventoryRepositoryImpl(
    private val fridgeInventoryDao: FridgeInventoryDao
) : FridgeInventoryRepository{
    override suspend fun getFridgeInventories(): Flow<List<FridgeInventoryModel>> {
        return withContext(Dispatchers.IO){
            return@withContext fridgeInventoryDao.getFridgeInventories().map { entityList ->
                entityList.map{FridgeInventoryEntity ->
                        FridgeInventoryEntity.toFridgeInventoryModel()
                    }
                }
        }

    }

    override suspend fun addFridgeInventory(fridgeInventoryModel: FridgeInventoryModel) {
        withContext(Dispatchers.IO) {
            fridgeInventoryDao.insertFridgeInventory(fridgeInventoryModel.fromModelToEntity())
        }
    }
}