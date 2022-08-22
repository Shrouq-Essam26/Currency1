package com.example.mywe.presentation.di

import com.example.mywe.data.api.Api

class RemoteApiHolder {
    private var remoteApi: Api? = null
    fun getRemoteApi() = remoteApi
    fun setRemoteApi(value: Api) {
        this.remoteApi = value
    }
}