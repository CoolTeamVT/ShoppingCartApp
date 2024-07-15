package com.main.domain.usecases.GetUsecases

import com.main.domain.models.FridgeInventoryModel
import com.main.domain.repositories.FridgeInventoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetFromFridgeInventoryDBUsecase {
    suspend fun execute (params: None) : Flow<List<FridgeInventoryModel>>

}
class GetFromFridgeInventoryDBUsecaseImpl @Inject constructor(
    private val fridgeInventoryRepository: FridgeInventoryRepository
): BasicGetUsecase<List<FridgeInventoryModel>, None>(), GetFromFridgeInventoryDBUsecase{
    override suspend fun execute(params: None): Flow<List<FridgeInventoryModel>> {
        return fridgeInventoryRepository.getFridgeInventories()
    }
}