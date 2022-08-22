package com.example.mywe.presentation.ui.activities.convertCurrency

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mywe.core.Resource
import com.example.mywe.data.model.Response
import com.example.mywe.domain.entities.AppConfigEntity
import com.example.mywe.domain.usecases.GetAppConfigUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConvertCurrencyViewModel @Inject constructor(private val getAppConfigUseCase: GetAppConfigUseCase) :
    ViewModel() {
    val config = MutableLiveData<Resource<AppConfigEntity>>()
    fun getConfig() {
        viewModelScope.launch(Dispatchers.IO) {
            config.postValue(Resource.loading(data = null))
            try {
                getAppConfigUseCase.build().collect {
                    config.postValue(Resource.success(data = it.data))
                }
            } catch (exception: Throwable) {
                config.postValue(
                    Resource.error(data = null, message = "error")
                )
            }
        }
    }
}