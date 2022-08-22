package com.example.mywe.data.repositories

import com.example.mywe.data.model.Response
import com.example.mywe.data.source.DataSource
import com.example.mywe.domain.entities.AppConfigEntity
import com.example.mywe.domain.repositories.IRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val dataSource: DataSource): IRepository{
    override suspend fun getAppConfig(): Flow<Response<AppConfigEntity>> {
        return dataSource.getAppConfig()
    }
}
