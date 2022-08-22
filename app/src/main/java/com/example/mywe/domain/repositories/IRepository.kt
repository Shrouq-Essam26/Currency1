package com.example.mywe.domain.repositories

import com.example.mywe.data.model.Response
import com.example.mywe.domain.entities.AppConfigEntity
import kotlinx.coroutines.flow.Flow

interface IRepository {
    suspend fun getAppConfig(): Flow<Response<AppConfigEntity>>
}