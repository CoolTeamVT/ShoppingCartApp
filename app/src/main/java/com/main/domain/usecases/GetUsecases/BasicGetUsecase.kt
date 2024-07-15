package com.main.domain.usecases.GetUsecases

import kotlinx.coroutines.flow.Flow

abstract class BasicGetUsecase <out Type, in Params> where Type: Any? {
    abstract suspend fun execute (params: Params) : Flow<Type>
}

object None