package com.example.mywe.presentation.ui.activities.convertCurrency

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import com.example.mywe.R
import com.example.mywe.core.Status
import com.example.mywe.databinding.ActivityConvertCurrencyBinding
import com.example.mywe.databinding.ActivitySplashBinding
import com.example.mywe.presentation.ui.common.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConvertCurrencyActivity : BaseActivity<ActivityConvertCurrencyBinding>() {
    private val viewModel: ConvertCurrencyViewModel by viewModels()

    override fun getViewBinding() = ActivityConvertCurrencyBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupToolbar(titleResId = R.string.app_name)
        viewModel.getConfig()
        viewModel.config.observe(this){

            it?.let { resource ->
                when (resource.status) {
                    Status.LOADING -> {
                        dialog.show()
                    }
                    Status.SUCCESS -> {
                        dialog.dismiss()
                      //  binding.tvHello.text = it.data?.android_version
                    }
                    Status.ERROR -> {
                        dialog.dismiss()
                    }
                }
            }

        }
    }
}