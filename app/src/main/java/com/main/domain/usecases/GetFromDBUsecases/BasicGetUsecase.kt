package com.main.domain.usecases.GetFromDBUsecases

abstract class BasicGetUsecase <out Type, in Params> where Type: Any? {
    abstract fun execute (params: Params) : Type
}

object None